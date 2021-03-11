package com.task.http.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthorizationReq {

	@NotEmpty(message = "description is required")
	private String description;
	@NotNull(message = "amount is required")
	@Min(message = "minimum value accepted 1", value = 1)
	private Long amount;
	@NotEmpty(message = "status is required")
	private String status;
	
	public AuthorizationReq() {
		super();
	}
	
	public AuthorizationReq(String description, Long amount, String status) {
		super();
		this.description = description;
		this.amount = amount;
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
