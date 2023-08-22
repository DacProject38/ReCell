package com.recell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recell.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
