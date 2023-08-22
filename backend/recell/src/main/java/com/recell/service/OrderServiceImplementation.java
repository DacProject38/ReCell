package com.recell.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recell.exception.OrderException;
import com.recell.model.Address;
import com.recell.model.Order;
import com.recell.model.User;
import com.recell.repository.CartRepository;

@Service
public class OrderServiceImplementation implements OrderService{
	
	private CartRepository cartRepository;
	private CartService cartService;
	private ProductService productService;
	
	public OrderServiceImplementation() {
	
	}
	
	public OrderServiceImplementation(CartRepository cartRepository, CartService cartService,ProductService productService) {
		this.cartRepository = cartRepository;
		this.cartService = cartService;
		this.productService = productService;
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
	public Order confirmedOrder(Long orderId) throws OrderException {
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
	public Order cancelledOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		
	}
	
}
