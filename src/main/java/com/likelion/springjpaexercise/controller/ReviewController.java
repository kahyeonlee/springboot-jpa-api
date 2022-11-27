package com.likelion.springjpaexercise.controller;

import com.likelion.springjpaexercise.domain.dto.ReviewCreateRequest;
import com.likelion.springjpaexercise.domain.dto.ReviewCreateResponse;
import com.likelion.springjpaexercise.domain.dto.ReviewReadResponse;
import com.likelion.springjpaexercise.domain.entity.Review;
import com.likelion.springjpaexercise.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
@Slf4j
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

//    @GetMapping("/{id}")
//    public ResponseEntity<ReviewReadResponse> get(@PathVariable Long id) {
//        Review review = reviewService.getReview(id);
//        ReviewReadResponse response = ReviewReadResponse.builder()
//                .id(review.getId())
//                .title(review.getTitle())
//                .content(review.getContent())
//                .patientName(review.getPatientName())
//                .hospitalName("병원이름 빈칸")
//                .build();
//        return ResponseEntity.ok().body(response);
//    }
    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Long id, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        log.info("{}", reviewCreateRequest);
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadResponse> get(@PathVariable Long id) {
        Review review = reviewService.getReview(id);
        ReviewReadResponse response = ReviewReadResponse.fromEntity(review);
        return ResponseEntity.ok().body(response);
    }


}