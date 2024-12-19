package com.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookShop.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);
	
	
}
