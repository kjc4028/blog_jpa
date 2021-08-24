package com.dev.jpa.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.jpa.usr.entity.UsrEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	public List<CategoryEntity> findByUseYn(String useYn);
	
	public List<CategoryEntity> findByUsrEntity(UsrEntity usrEntity);
	
	public List<CategoryEntity> findByUsrEntityAndUseYn(UsrEntity usrEntity, String useYn);
	
}
