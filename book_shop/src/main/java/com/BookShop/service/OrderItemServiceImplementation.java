package com.BookShop.service;

import org.springframework.stereotype.Service;

import com.BookShop.model.OrderItem;

@Service
public class OrderItemServiceImplementation implements OrderItemService{
	
	private OrderItemRepository orderItemRepository;
	
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemRepository.save(orderItem);
	}

}
