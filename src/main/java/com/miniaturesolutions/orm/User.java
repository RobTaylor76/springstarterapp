package com.miniaturesolutions.orm;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	private long id;
	private String email;
	private List<Role> roles = new ArrayList<>();
	private String password;
	
	public User(String email) {
		this.email = email;
	}

	User() {
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	@Column(unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	protected void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
