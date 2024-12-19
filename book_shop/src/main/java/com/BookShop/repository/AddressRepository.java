package com.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookShop.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
