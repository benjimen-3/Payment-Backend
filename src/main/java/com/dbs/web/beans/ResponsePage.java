package com.dbs.web.beans;

public class ResponsePage {

	private String message;
	private String description;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResponsePage(String message, String description) {
		super();
		this.message = message;
		this.description = description;
	}

	public ResponsePage() {
		super();
		// TODO Auto-generated constructor stub
	}

}
