package com.dev.jpa.bbs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dev.jpa.usr.entity.UsrEntity;

@Service
@Transactional
public class BbsService {

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
	
}
