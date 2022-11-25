package com.likelion.springjpaexercise.repository;

import com.likelion.springjpaexercise.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
