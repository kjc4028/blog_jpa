package com.dev.jpa.bbs;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.jpa.usr.entity.UsrEntity;


public interface BbsRepository extends JpaRepository<BbsEntity, Long>{

	//게시물 상세 조회
	BbsEntity findByBbsSeq(int bbsSeq);
	
	//사용자가 등록한 게시물 조회
	List<BbsEntity> findByUsrEntity(UsrEntity usrEntity);

	Page<BbsEntity> findByUsrEntity(UsrEntity usrEntity, Pageable pageable);
	
	//공개 게시물만 조회
	Page<BbsEntity> findByUseYn(String useYn, Pageable pageable);

	//게시물 전체검색
	//TODO QueryDSL 사용하여 UseYn and (title or contents) 쿼리로 변경하기
	//Page<BbsEntity> findByUseYnAndTitleContainsOrContentsContains(String useYn, String title, String contents, Pageable pageable);
	Page<BbsEntity> findByTitleContainsOrContentsContains(String title, String contents, Pageable pageable);
	
	
}
