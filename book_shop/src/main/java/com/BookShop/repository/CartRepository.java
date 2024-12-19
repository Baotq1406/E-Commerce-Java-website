package com.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BookShop.model.Cart;
import com.BookShop.model.CartItem;
import com.BookShop.model.Product;

public interface CartRepository extends JpaRepository<Cart, Long>{

	@Query("SELECT c From Cart c Where c.user.id=:userId")
	public Cart findByUserId(@Param("userId")Long userId);
}
