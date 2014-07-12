package com.xebia.pricer.entity;

import java.util.Date;

/**
 * Entity to be stored in DB
 * This will hold product data
 *
 */
public class Product {

	String barCode; //primary key
	Date createdDate;
	String createdBy;
	
	String name;
	String notes;
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Product(String barCode,
			String name, String notes, String createdBy) {
		super();
		this.barCode = barCode;
		this.createdDate = new Date();
		this.createdBy = createdBy;
		this.name = name;
		this.notes = notes;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
