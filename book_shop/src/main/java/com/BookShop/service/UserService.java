package com.BookShop.service;

import com.BookShop.exception.UserException;
import com.BookShop.model.User;

public interface UserService {

	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
}
