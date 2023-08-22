package com.recell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recell.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
