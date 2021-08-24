package com.dev.jpa.usr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name="TB_USR_ROLE")
public class RoleUsrEntity {

	public RoleUsrEntity() {
	}
	
	@Id
	@Column(nullable = false)
	private String usrId;
	
	@Column(nullable = false)
	private String roleCd;
	
}
