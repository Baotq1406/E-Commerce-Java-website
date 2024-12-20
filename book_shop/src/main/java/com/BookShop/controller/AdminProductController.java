package com.BookShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookShop.exception.ProductException;
import com.BookShop.model.Product;
import com.BookShop.request.CreateProductRequest;
import com.BookShop.response.ApiResponse;
import com.BookShop.service.ProductService;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Product> CreateProduct(@RequestBody CreateProductRequest req) {
		
		Product product=productService.createProduct(req);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}/update")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException {
		
		productService.deleteProduct(productId);
		ApiResponse res=new ApiResponse();
		
		res.setMessage("product delete successfull");
		res.setStatus(true);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PutMapping("/{productId}/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product req, @PathVariable Long productID) 
			throws ProductException  {
		Product product=productService.updateProduct(productID, req);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] req) {
		for (CreateProductRequest product:req) {
			productService.createProduct(product);
		}
		
		ApiResponse res = new ApiResponse();
		res.setMessage("product created successfully");
		res.setStatus(true);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
}
