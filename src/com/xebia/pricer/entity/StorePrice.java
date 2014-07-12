package com.xebia.pricer.entity;

import java.util.Date;

/**
 * Entity to be stored in DB
 * This will hold each stores price
 *
 */
public class StorePrice {
	
	Integer serialNo; //primary key
	String store;
	String barCode; // foreign key for Product Table
	Double price;
	String notes;
	
	Date createdDate;
	String createdBy;
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
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
	@Override
	public String toString() {
		return "StorePrice [barCode=" + barCode + ", price=" + price + "]";
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public StorePrice() {
		super();
		createdDate = new Date();
		createdBy = "Agent Name";
	}
	public StorePrice(Integer serialNo, String store, String barCode,
			Double price, String createdBy) {
		super();
		this.serialNo = serialNo;
		this.store = store;
		this.barCode = barCode;
		this.price = price;
		this.createdBy = createdBy;
		createdDate = new Date();
	}
	
	
	
}
