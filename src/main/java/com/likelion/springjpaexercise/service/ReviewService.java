package com.likelion.springjpaexercise.service;

import com.likelion.springjpaexercise.domain.dto.ReviewCreateRequest;
import com.likelion.springjpaexercise.domain.dto.ReviewCreateResponse;
import com.likelion.springjpaexercise.domain.entity.Hospital;
import com.likelion.springjpaexercise.domain.entity.Review;
import com.likelion.springjpaexercise.repository.HospitalRepository;
import com.likelion.springjpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewCreateResponse createReview(ReviewCreateRequest dto) {
        //Hospital 불러오기
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(dto.getHospitalId());

        //ReviewEntity만들기
        Review review = Review.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .patientName(dto.getUserName())
                .hospital(hospitalOptional.get())
                .build();
        //저장
        Review savedReview = reviewRepository.save(review);
        //반환
        return new ReviewCreateResponse().builder()
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .userName(savedReview.getPatientName())
                .message("리뷰 등록이 성공하였습니다.")
                .build();
    }

    public Review getReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id가 없습니다."));
        return review;
    }
}