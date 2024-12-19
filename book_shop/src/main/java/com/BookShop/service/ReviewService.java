package com.BookShop.service;

import java.util.List;

import com.BookShop.exception.ProductException;
import com.BookShop.model.Review;
import com.BookShop.model.User;
import com.BookShop.request.ReviewRequest;

public interface ReviewService {
	
	public Review createReview(ReviewRequest req, User user)throws ProductException;
	public List<Review> getAllReview(Long productId);
	
}
