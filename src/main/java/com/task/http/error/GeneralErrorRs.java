package com.task.http.error;

public class GeneralErrorRs {

	private String message;
	private Integer status;
	
	public GeneralErrorRs() {
		super();
	}
	
	public GeneralErrorRs(String message, Integer status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
