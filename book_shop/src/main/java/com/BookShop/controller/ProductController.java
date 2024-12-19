package com.BookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookShop.exception.ProductException;
import com.BookShop.model.Product;
import com.BookShop.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Page<Product>>findProductByCategotyHandler(@RequestParam String category,
			@RequestParam Integer minPricem, @RequestParam Integer maxPrice, @RequestParam Integer minDiscount, 
			@RequestParam String sort, @RequestParam String stock, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		
		Page<Product> res= productService.getAllProduct(category, minPricem, maxPrice, minDiscount, sort, stock, pageNumber, pageSize);
		
		System.out.println("complete products");
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products/id/{productId}")
	public ResponseEntity<Product>findProductByIdHandler(@PathVariable Long productId) throws ProductException{
		Product product=productService.findProductById(productId);
		
		return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
	}
	
}
