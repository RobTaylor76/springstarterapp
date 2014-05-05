package com.miniaturesolutions.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

	private long id;
	private String email;
	private List<RoleModel> roles = new ArrayList<>();
	
	public UserModel() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<RoleModel> getRoles() {
		return roles;
	}
	
	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
}
