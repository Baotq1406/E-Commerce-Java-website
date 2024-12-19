package com.BookShop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BookShop.config.JwtProvider;
import com.BookShop.exception.UserException;
import com.BookShop.model.User;
import com.BookShop.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	
	public UserServiceImplementation(UserRepository userRepository, JwtProvider jwtProvider) {
		// TODO Auto-generated constructor stub
		this.userRepository=userRepository;
		this.jwtProvider=jwtProvider;
		
	}
	
	@Override
	public User findUserById(Long userId) throws UserException {
		// TODO Auto-generated method stub
		Optional<User>user=userRepository.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("user not found with id: "+ userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		// TODO Auto-generated method stub
		String email=jwtProvider.getEmailFromToken(jwt);
		
		User user=userRepository.findByEmail(email);
		
		if(user == null) {
			throw new UserException("user not found with email: "+ email);
		}
		return user;
	}

}
