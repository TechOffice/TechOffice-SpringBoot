package com.techoffice.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingItem implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String name;
	private BigDecimal price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
