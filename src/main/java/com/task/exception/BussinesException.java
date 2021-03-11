package com.task.exception;

public class BussinesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String operation;
	private String message;
	private Integer status;
	
	public BussinesException() {
		super();
	}

	public BussinesException(String operation, String message, Integer status) {
		super();
		this.operation = operation;
		this.message = message;
		this.status = status;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
