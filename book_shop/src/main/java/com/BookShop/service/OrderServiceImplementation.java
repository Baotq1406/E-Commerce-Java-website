package com.BookShop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.aop.target.AbstractLazyCreationTargetSource;
import org.springframework.stereotype.Service;

import com.BookShop.exception.OrderException;
import com.BookShop.model.Address;
import com.BookShop.model.Cart;
import com.BookShop.model.CartItem;
import com.BookShop.model.Order;
import com.BookShop.model.OrderItem;
import com.BookShop.model.User;
import com.BookShop.repository.AddressRepository;
import com.BookShop.repository.CartRepository;
import com.BookShop.repository.OrderRepository;
import com.BookShop.repository.UserRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	//private CartRepository cartRepository;
	private OrderRepository orderRepository;
	private CartService cartItemService;
	//private ProductService productService;
	private AddressRepository addressRepository;
	private UserRepository userRepository;
	private OrderItemService orderItemService;
	private OrderItemRepository orderItemRepository;
	
	
	public OrderServiceImplementation(OrderRepository orderRepository,
			CartService cartItemService,
			AddressRepository addressRepository,
			UserRepository userRepositor,
			OrderItemService orderItemService,
			OrderItemRepository orderItemRepository) {
		// TODO Auto-generated constructor stub
		this.orderItemRepository=orderItemRepository;
		this.cartItemService=cartItemService;
		this.addressRepository=addressRepository;
		this.userRepository=userRepositor;
		this.orderItemService=orderItemService;
		this.orderItemRepository=orderItemRepository;
		//this.cartRepository=cartRepository;
		//this.productService=productService;
	}
	
	@Override
	public Order createOrder(User user, Address shippAddress) {
		// TODO Auto-generated method stub
		shippAddress.setUser(user);
		Address address=addressRepository.save(shippAddress);
		user.getAddress().add(address);
		userRepository.save(user);
		
		Cart cart=cartItemService.findUserCart(user.getId());
		List<OrderItem> orderItems=new ArrayList<>();
		
		for(CartItem item: cart.getCartItems()) {
			OrderItem orderItem=new OrderItem();
			
			orderItem.setPrice(item.getPrice());
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setUserId(item.getUserId());
			orderItem.setDiscountedPrice(item.getDiscountedPrice());
			
			OrderItem createdOrderItem=orderItemRepository.save(orderItem);
			
			orderItems.add(createdOrderItem);
		}
		
		Order createdOrder=new Order();
		createdOrder.setUser(user);
		createdOrder.setOtherItems(orderItems);
		createdOrder.setTotalPrice(cart.getTotalPrice());
		createdOrder.setTotalDiscountedPrice(cart.getTotalDiscountedPrice());
		createdOrder.setDiscount(cart.getDiscounte());
		createdOrder.setTotalItem(cart.getTotalItem());
		
		createdOrder.setShippingAddress(address);
		createdOrder.setOrderDate(LocalDateTime.now());
		createdOrder.setOrderStatus("PENDING");
		createdOrder.getPaymentDetails().setStatus("PENDING");
		createdOrder.setCreateAt(LocalDateTime.now());
		
		Order savedOrder=orderRepository.save(createdOrder);
		
		for(OrderItem item:orderItems) {
			item.setOrder(savedOrder);
			orderItemRepository.save(item);
		}
		
		return savedOrder;
	}

	@Override
	public Order findOrderById(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		Optional<Order> opt=orderRepository.findById(orderId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new OrderException("order not exist with od" + orderId);
	}

	@Override
	public List<Order> usersOrderHistory(Long userId) {
		// TODO Auto-generated method stub
		List<Order> orders=orderRepository.getUsersOrders(userId);
		return orders;
	}

	@Override
	public Order placedOrder(Long orderId) throws OrderException {
		Order order=findOrderById(orderId);
		order.setOrderStatus("PLACED");
		order.getPaymentDetails().setStatus("COMPLETED");
		return order;
	}

	@Override
	public Order shippedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		Order order=findOrderById(orderId);
		order.setOrderStatus("SHIPPED");
		return orderRepository.save(order);
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		Order order=findOrderById(orderId);
		order.setOrderStatus("DELIVERED");
		return orderRepository.save(order);
	}

	@Override
	public Order cancledOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		Order order=findOrderById(orderId);
		order.setOrderStatus("CANCELLED");
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		Order order=findOrderById(orderId);
		
		orderRepository.deleteById(orderId);;
	}

	@Override
	public Order confirmedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		Order order=findOrderById(orderId);
		order.setOrderStatus("CONFIRNED");
		return orderRepository.save(order);
	}
	
}
