package com.nestjavatraining.entity;

import java.util.Date;

public class Product {
	
	
	
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productDescription="
				+ productDescription + ", activationDate=" + activationDate + ", expiryDate=" + expiryDate + "]";
	}

	private String productCode; 
	private String productName; 
	private String productDescription; 
	private Date activationDate; 
	private Date expiryDate;
	
	public Product(String productCode, String productName, String productDescription, Date activationDate,
			Date expiryDate) {
		this.productCode = productCode;
		this.productName = productName;
		this.productDescription = productDescription;
		this.activationDate = activationDate;
		this.expiryDate = expiryDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	

}
