package com.likelion.springjpaexercise.controller;

import com.likelion.springjpaexercise.domain.dto.HospitalReadResponse;
import com.likelion.springjpaexercise.domain.dto.ReviewCreateRequest;
import com.likelion.springjpaexercise.domain.dto.ReviewCreateResponse;
import com.likelion.springjpaexercise.domain.dto.ReviewReadResponse;
import com.likelion.springjpaexercise.domain.entity.Hospital;
import com.likelion.springjpaexercise.domain.entity.Review;
import com.likelion.springjpaexercise.service.HospitalService;
import com.likelion.springjpaexercise.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hospitals")
@Slf4j
@RequiredArgsConstructor
public class HospitalController {

    private final ReviewService reviewService;
    private final HospitalService hospitalService;

    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> reviews(@PathVariable Long hospitalId) {
        return ResponseEntity.ok().body(reviewService.findAllByHospitalId(hospitalId));
    }

    @GetMapping("/{hospitalId}")
    public ResponseEntity<HospitalReadResponse> get(@PathVariable Long hospitalId) {
        Hospital hospital = hospitalService.findById(hospitalId);
        HospitalReadResponse response = HospitalReadResponse.fromEntity(hospital);
        return ResponseEntity.ok().body(response);
    }
}
