package com.dev.jpa.city;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long>{
	
	public CityEntity findByCityNm(String name);
	
	public CityEntity findByCityId(Long id);
}
