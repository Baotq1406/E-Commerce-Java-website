package com.BookShop.service;

import com.BookShop.exception.ProductException;
import com.BookShop.model.Cart;
import com.BookShop.model.User;
import com.BookShop.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);
}
