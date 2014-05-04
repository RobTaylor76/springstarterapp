package com.miniaturesolutions.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Role {


	private long id;

	public Role() {

	}


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}
	

	private User owner;
	private String name;
	private RoleType roleType;
	
	@ManyToOne
	public User getUser() {
		return owner;
	}
	
	public void setUser(User owner) {
		this.owner = owner;
	}
	
	@ManyToOne
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType type) {
		this.roleType = type;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
