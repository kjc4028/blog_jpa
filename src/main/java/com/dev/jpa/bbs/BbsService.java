package com.dev.jpa.bbs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dev.jpa.usr.entity.UsrEntity;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
@Transactional
public class BbsService {

	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Autowired
	private BbsRepository bbsRepository;
	
	public void save(BbsEntity bbsEntity) {
		bbsRepository.save(bbsEntity);
	}
	
	public List<BbsEntity> findAll(){
		return bbsRepository.findAll();
	}

	
	public Page<BbsEntity> findAllPage(int pageNum){
		return bbsRepository.findAll( PageRequest.of(pageNum-1, 10, Sort.by(Sort.Direction.DESC, "bbsSeq")));
	}

	public List<BbsEntity> findOpenList(int pageNum){
		Page<BbsEntity> page = bbsRepository.findByUseYn("Y", PageRequest.of(pageNum-1, 10, Sort.by(Sort.Direction.DESC, "bbsSeq")));
		return page.getContent();
	}

	public Page<BbsEntity> findOpenPage(int pageNum){
		Page<BbsEntity> page = bbsRepository.findByUseYn("Y", PageRequest.of(pageNum-1, 10, Sort.by(Sort.Direction.DESC, "bbsSeq")));
		return page;
	}
	
	@Cacheable(value = "bbsListMain")
	public Page<BbsEntity> findOpenPageMain(int pageNum){
		Page<BbsEntity> page = bbsRepository.findByUseYn("Y", PageRequest.of(pageNum-1, 10, Sort.by(Sort.Direction.DESC, "bbsSeq")));
		return page;
	}

	public List<BbsEntity> findByUsrEntity(String userId){
		UsrEntity usrEntity = new UsrEntity();
		usrEntity.setUsrId(userId);
		return bbsRepository.findByUsrEntity(usrEntity);
	}

	public Page<BbsEntity> findByUsrEntityPage(String userId, int pageNum){
		UsrEntity usrEntity = new UsrEntity();
		usrEntity.setUsrId(userId);
		return bbsRepository.findByUsrEntity(usrEntity, PageRequest.of(pageNum-1, 10, Sort.by(Sort.Direction.DESC, "bbsSeq")));
	}

	public BbsEntity findByBbsSeq(int bbsSeq) {
		return bbsRepository.findByBbsSeq(bbsSeq);
	}

	/**
	 * 전체검색
	 * @param bbsEntity
	 * @param pageNum
	 * @return
	 */
	public Page<BbsEntity> findByUseYnAndLikeTitleAndContents(BbsEntity bbsEntity, int pageNum) {
		//return bbsRepository.findByTitleContainsOrContentsContains(bbsEntity.getUseYn(),bbsEntity.getTitle(),bbsEntity.getContents(), PageRequest.of(pageNum-1, 10, Sort.by(Sort.Direction.DESC, "bbsSeq")));
		return bbsRepository.findByTitleContainsOrContentsContains(bbsEntity.getTitle(),bbsEntity.getContents(), PageRequest.of(pageNum-1, 10, Sort.by(Sort.Direction.DESC, "bbsSeq")));
	}

	/**
	 * QueryDSL을 이용한 전체 검색
	 * @param srchTxt
	 * @param pageNum
	 * @return
	 */
	public Page<BbsEntity> findByUseYnAndLikeTitleAndContentsForDsl(String srchTxt, int pageNum) {
		
		QBbsEntity qBbsEntity = QBbsEntity.bbsEntity;
		
		QueryResults<BbsEntity> fetched = (QueryResults<BbsEntity>) queryFactory
				.selectFrom(qBbsEntity.bbsEntity)
				.where(QBbsEntity.bbsEntity.title.contains(srchTxt).or(QBbsEntity.bbsEntity.contents.contains(srchTxt)))
				.where(QBbsEntity.bbsEntity.useYn.eq("Y"))
				.limit(10)
				.offset((pageNum-1)*10)
				.orderBy(qBbsEntity.regDate.desc())
				.fetchResults();
		
		List<BbsEntity> result = fetched.getResults();
		 
		Pageable pageAble = PageRequest.of(pageNum-1, 10, Sort.by(Sort.Order.desc("bbsSeq")));
		
		Long total = fetched.getTotal();
		
		return new PageImpl<>(result, pageAble, total);
	}
	
	
}
