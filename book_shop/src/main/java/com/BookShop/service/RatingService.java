package com.BookShop.service;

import java.util.List;

import com.BookShop.exception.ProductException;
import com.BookShop.model.Rating;
import com.BookShop.model.User;
import com.BookShop.request.RatingRequest;

public interface RatingService {
	
	public Rating createRating(RatingRequest req, User user) throws ProductException;
	public List<Rating>getProductsRating(Long productId);
	
	
}
