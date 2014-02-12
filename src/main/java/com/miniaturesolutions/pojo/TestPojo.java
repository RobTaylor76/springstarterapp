package com.miniaturesolutions.pojo;

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
	

	public InnerPojo[] getInnerPojos() {
		return innerPojos;
	}

	public void setInnerPojos(InnerPojo[] innerPojos) {
		this.innerPojos = innerPojos;
	}


	private String name = "";
	private String message = "";
	private InnerPojo innerPojo = new InnerPojo();
	private InnerPojo[] innerPojos = new InnerPojo[10];
}
