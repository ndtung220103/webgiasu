package com.webgiasu.dto;

;

public class UserDTO extends BaseDTO {

	private String Username ;
	private String Password;
	private String Roles;
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
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	
	
}
