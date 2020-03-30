package com.techoffice.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techoffice.model.ShoppingCart;
import com.techoffice.model.ShoppingItem;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@RequestMapping("/getShoppingCart")
	public ShoppingCart getShoppingCart(HttpSession session){
		if (session.getAttribute("ShoppingCart") instanceof ShoppingCart){
			ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
			return shoppingCart;
		}
		return new ShoppingCart();
	}
	
	@RequestMapping("/addShoppingItem")
	@ResponseBody
	public String addShoppingItem(HttpSession session){
		if (session.getAttribute("ShoppingCart") instanceof ShoppingCart){
			ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
			ShoppingItem item = new ShoppingItem();
			item.setName("Item1");
			item.setPrice(BigDecimal.valueOf(100));
			shoppingCart.add(item);
			session.setAttribute("ShoppingCart", shoppingCart);
		}else{
			ShoppingCart shoppingCart = new ShoppingCart();
			ShoppingItem item = new ShoppingItem();
			item.setName("Item1");
			item.setPrice(BigDecimal.valueOf(100));
			shoppingCart.add(item);
			session.setAttribute("ShoppingCart", new ShoppingCart());
		}
		return "added";
	}
}
