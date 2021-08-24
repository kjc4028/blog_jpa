package com.dev.jpa.category;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.jpa.usr.entity.UsrEntity;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void save(CategoryEntity categoryEntity) {
		categoryRepository.save(categoryEntity);
	}
	
	public List<CategoryEntity> findAll(){
		return categoryRepository.findAll();
	}

	public List<CategoryEntity> findByUsrEntityAndUseYn(String userId){
		UsrEntity usrEntity = new UsrEntity();
		usrEntity.setUsrId(userId);
		return categoryRepository.findByUsrEntityAndUseYn(usrEntity, "Y");
	}
	
	public List<CategoryEntity> findByUseYn(String useYn){
		return categoryRepository.findByUseYn(useYn);
	}
	
	public List<CategoryEntity> findByUsrEntity(UsrEntity usrEntity){
		return categoryRepository.findByUsrEntity(usrEntity);
	}
}
