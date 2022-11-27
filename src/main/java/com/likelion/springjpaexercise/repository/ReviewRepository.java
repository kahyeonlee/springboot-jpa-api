package com.likelion.springjpaexercise.repository;

import com.likelion.springjpaexercise.domain.entity.Hospital;
import com.likelion.springjpaexercise.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHospital(Hospital hospital);
}