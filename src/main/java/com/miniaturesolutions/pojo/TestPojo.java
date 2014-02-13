package com.miniaturesolutions.pojo;

import java.util.LinkedList;
import java.util.List;

public class TestPojo {

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public InnerPojo getInnerPojo() {
		return innerPojo;
	}

	public void setInnerPojo(InnerPojo innerPojo) {
		this.innerPojo = innerPojo;
	}
	

	public List<InnerPojo> getInnerPojos() {
		return innerPojos;
	}

	public void setInnerPojos( List<InnerPojo> innerPojos) {
		this.innerPojos = innerPojos;
	}


	private String name = "";
	private String message = "";
	private InnerPojo innerPojo = new InnerPojo();
	private List<InnerPojo> innerPojos = new LinkedList<InnerPojo>();;
}
