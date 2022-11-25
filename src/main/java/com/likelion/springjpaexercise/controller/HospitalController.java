package com.likelion.springjpaexercise.controller;

import com.likelion.springjpaexercise.domain.dto.ReviewCreateRequest;
import com.likelion.springjpaexercise.domain.dto.ReviewCreateResponse;
import com.likelion.springjpaexercise.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        log.info("{}", reviewCreateRequest);
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }


}
