package com.recell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recell.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
