package com.BookShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BookShop.exception.OrderException;
import com.BookShop.model.Address;
import com.BookShop.model.Order;
import com.BookShop.model.User;
import com.BookShop.repository.CartRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	private CartRepository cartRepository;
	private CartService cartItemService;
	private ProductService productService;
	
	public OrderServiceImplementation(CartRepository cartRepository,
			CartService cartItemService,
			ProductService productService) {
		// TODO Auto-generated constructor stub
		
		this.cartItemService=cartItemService;
		this.cartRepository=cartRepository;
		this.productService=productService;
	}
	
	@Override
	public Order createOrder(User user, Address shippingAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderById(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> usersOrderHistory(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order placedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order shippedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order cancledOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAlOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
