package com.dev.jpa.usr.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.jpa.usr.entity.RoleUsrEntity;
import com.dev.jpa.usr.repository.RoleUsrRepository;


@Service
@Transactional
public class RoleUsrService  {
	
	Logger log = LoggerFactory.getLogger(RoleUsrService.class);
	
	@Autowired
	RoleUsrRepository roleUsrRepository;
	
	public void save(RoleUsrEntity roleUsrEntity) {
		roleUsrRepository.save(roleUsrEntity);
	}
	
}
