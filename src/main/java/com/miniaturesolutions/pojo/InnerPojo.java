package com.miniaturesolutions.pojo;

public class InnerPojo {
	public InnerPojo() {}
	public InnerPojo(String opinion) {
		this.opinion = opinion;
	}	

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	private String opinion = "";
	
	private String text = "";

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
