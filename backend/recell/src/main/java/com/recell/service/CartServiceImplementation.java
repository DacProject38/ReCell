package com.recell.service;

import org.springframework.stereotype.Service;

import com.recell.exception.ProductException;
import com.recell.model.Cart;
import com.recell.model.User;
import com.recell.repository.CartRepository;
import com.recell.request.AddItemRequest;

@Service
public class CartServiceImplementation implements CartService{
	
	private CartRepository cartRepository;
	private CartItemService cartItemService;
	private ProductService productService;
	
	public CartServiceImplementation() {

	}	

	public CartServiceImplementation(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
		this.cartRepository = cartRepository;
		this.cartItemService = cartItemService;
		this.productService = productService;
	}

	@Override
	public Cart createCart(User user) {
		
		Cart cart= new Cart();
		cart.setUser(user);
		return cartRepository.save(cart);
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findUserCart(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
