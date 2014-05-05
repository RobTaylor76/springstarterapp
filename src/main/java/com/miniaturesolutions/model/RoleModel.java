package com.miniaturesolutions.model;

public class RoleModel {
	private long id;
	private UserModel owner;
	private String name;
	private RoleTypeModel roleType;
	
	public RoleModel() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public UserModel getUser() {
		return owner;
	}
	
	public void setUser(UserModel owner) {
		this.owner = owner;
	}
	
	public RoleTypeModel getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleTypeModel type) {
		this.roleType = type;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
