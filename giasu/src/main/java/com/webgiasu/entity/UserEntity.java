package com.webgiasu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	
	@Column(name = "username", columnDefinition = "VARCHAR(100) ")
	private String Username ;
	
	@Column(name="password",columnDefinition = "VARCHAR(100) ")
	private String Password;
	
	@Column(name="roles",columnDefinition = "VARCHAR(20) ")
	private String Roles;
	
	public String getRoles() {
		return Roles;
	}

	public void setRoles(String roles) {
		Roles = roles;
	}

	@OneToMany(mappedBy="SVDK")
	private List<LopDKSVEntity> dslsvdk = new ArrayList<>();
	
	@OneToMany(mappedBy="PHDK")
	private List<LopDKPHEntity> dslphdk = new ArrayList<>();
	
	@OneToMany(mappedBy="SV")
	private List<LopSVEntity> dslsv = new ArrayList<>();
	
	@OneToMany(mappedBy="PH")
	private List<LopPHEntity> dslph = new ArrayList<>();
	
	@OneToMany(mappedBy="nhantb")
	private List<NoticeEntity> dstb = new ArrayList<>();
	
	@OneToMany(mappedBy="ReciveSV")
	private List<LopPHEntity> dslnsv = new ArrayList<>();
	
	@OneToMany(mappedBy="RecivePH")
	private List<LopSVEntity> dslnph = new ArrayList<>();
	


	public List<LopPHEntity> getDslnsv() {
		return dslnsv;
	}

	public void setDslnsv(List<LopPHEntity> dslnsv) {
		this.dslnsv = dslnsv;
	}

	public List<LopSVEntity> getDslnph() {
		return dslnph;
	}

	public void setDslnph(List<LopSVEntity> dslnph) {
		this.dslnph = dslnph;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<LopDKPHEntity> getDslphdk() {
		return dslphdk;
	}

	public void setDslphdk(List<LopDKPHEntity> dslphdk) {
		this.dslphdk = dslphdk;
	}

	public List<LopSVEntity> getDslsv() {
		return dslsv;
	}

	public void setDslsv(List<LopSVEntity> dslsv) {
		this.dslsv = dslsv;
	}

	public List<LopPHEntity> getDslph() {
		return dslph;
	}

	public void setDslph(List<LopPHEntity> dslph) {
		this.dslph = dslph;
	}

	public List<NoticeEntity> getDstb() {
		return dstb;
	}

	public void setDstb(List<NoticeEntity> dstb) {
		this.dstb = dstb;
	}

	public List<LopDKSVEntity> getDslsvdk() {
		return dslsvdk;
	}

	public void setDslsvdk(List<LopDKSVEntity> dslsvdk) {
		this.dslsvdk = dslsvdk;
	}


	
	
}
