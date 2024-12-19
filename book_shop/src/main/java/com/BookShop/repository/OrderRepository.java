package com.BookShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BookShop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("SELECT o FROM Order o WHERE o.user.id =:userId AND (o.orderStatus = com.BookShop.model.OrderStatus.PLACED OR o.orderStatus = com.BookShop.model.OrderStatus.CONFIRMED OR o.orderStatus = com.BookShop.model.OrderStatus.SHIPPED OR o.orderStatus = com.BookShop.model.OrderStatus.DELIVERED)")
	public List<Order> getUsersOrders(@Param("UserId")Long userId);
}
