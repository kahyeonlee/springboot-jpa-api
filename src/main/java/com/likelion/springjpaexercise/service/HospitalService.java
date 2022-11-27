package com.likelion.springjpaexercise.service;

import com.likelion.springjpaexercise.domain.dto.HospitalReadResponse;
import com.likelion.springjpaexercise.domain.entity.Hospital;
import com.likelion.springjpaexercise.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public Hospital findById(Long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id가 없습니다."));
        return hospital;
    }
}