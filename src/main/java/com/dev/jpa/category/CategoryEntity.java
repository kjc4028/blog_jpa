package com.dev.jpa.category;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

import com.dev.jpa.bbs.BbsEntity;
import com.dev.jpa.usr.entity.RoleUsrEntity;
import com.dev.jpa.usr.entity.UsrEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TB_CATEGORY")
public class CategoryEntity {
	
	
	public CategoryEntity() {
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int categorySeq;
	
	/*@Column(name="usr_id")
	private String usrId;*/
	@ManyToOne
	@JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "usrEntity", value = ConstraintMode.CONSTRAINT))
	private UsrEntity usrEntity;
	
	@Column
	private String categoryNm;
	
	@Column
	private Date regDate;
	
	@Column(length = 1, nullable = false)
	private String useYn;
	
	@PrePersist
	public void prepersist() {
		this.useYn = this.useYn == null ? "N" : this.useYn;
		this.regDate = new Date();
	}
	
}
