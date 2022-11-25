package com.likelion.springjpaexercise.repository;

import com.likelion.springjpaexercise.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
