package com.dev.jpa.city;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CityService {

	@Autowired
	CityRepository cityRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public void saveEm(CityEntity cityEntity){
		em.persist(cityEntity);
	}
	
	
	public List<CityEntity> findAll(){
		try {
			return cityRepository.findAll();
		} catch (Exception e) {
			System.out.println("=======================================error");
			return null;
		}
	}
	
	public void saveCity(CityEntity cityEntity){
		cityRepository.save(cityEntity);
	}
	
	public CityEntity findByName(String cityNm){
		return cityRepository.findByCityNm(cityNm);
	}

	public CityEntity findByCityId(Long id){
		return cityRepository.findByCityId(id);
	}
	
	public void deleteById(Long id){
		cityRepository.deleteById(id);
	}
}
