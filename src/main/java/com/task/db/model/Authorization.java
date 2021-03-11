package com.task.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authorization")
public class Authorization {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "Description")
	private String description;
	@Column(name = "Amount")
	private Long amount;
	@Column(name = "Estatus")
	private String status;
	
	public Authorization() {
		super();
	}
	
	public Authorization(Integer id, String description, Long amount, String status) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
