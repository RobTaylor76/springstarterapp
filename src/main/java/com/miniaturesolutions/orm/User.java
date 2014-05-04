package com.miniaturesolutions.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	 private long id;
	  private String email;

	  public User(String email) {
	    this.email = email;
	  }

	  User() {
	  }
	  
	  @Column(unique=true)
	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }


	  @Id
	  @GeneratedValue
	  public long getId() {
	    return id;
	  }

	  protected void setId(long id) {
	    this.id = id;
	  }
}
