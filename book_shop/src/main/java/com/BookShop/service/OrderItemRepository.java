package com.BookShop.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookShop.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
