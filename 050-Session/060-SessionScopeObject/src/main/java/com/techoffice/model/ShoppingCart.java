package com.techoffice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ShoppingItem> shoppingItemList = new ArrayList<ShoppingItem>();

	public List<ShoppingItem> getShoppingItemList() {
		return shoppingItemList;
	}

	public void setShoppingItemList(List<ShoppingItem> shoppingItemList) {
		this.shoppingItemList = shoppingItemList;
	}
	
	public void add(ShoppingItem shoppingItem){
		this.shoppingItemList.add(shoppingItem);
	}
	
}
