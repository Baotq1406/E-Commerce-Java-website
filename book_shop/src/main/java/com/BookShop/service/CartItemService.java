package com.BookShop.service;

import com.BookShop.exception.CartItemException;
import com.BookShop.exception.UserException;
import com.BookShop.model.Cart;
import com.BookShop.model.CartItem;
import com.BookShop.model.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartitem)throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart, Product product, Long userId);
	
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
		
} 
