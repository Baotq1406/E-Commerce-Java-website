package com.BookShop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") // Renamed the table to avoid reserved SQL keyword conflict
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="order_id")
    private String orderId;
    
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<OrderItem> otherItems = new ArrayList<>(); // Fixed the typo "ortherItems"
    
    private LocalDateTime orderDate;
    
    private LocalDateTime deliveryDate;
    
    @OneToOne 
    private Address shippingAddress;
    
    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();
    
    private double totalPrice;
    
    private Integer totalDiscountedPrice;
    
    private Integer discount; // Renamed 'discounte' to 'discount' for correctness
    
    private String orderStatus;
    
    private int totalItem; // Renamed 'totallItem' to 'totalItem' for correctness
    
    private LocalDateTime createAt;
    
    public Order() {
        // No-arg constructor
    }
}
