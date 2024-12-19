package com.BookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookShop.exception.UserException;
import com.BookShop.model.User;
import com.BookShop.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
		
	public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization")String jwt) throws UserException {
		
		User user=userService.findUserProfileByJwt(jwt);
		
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
}
