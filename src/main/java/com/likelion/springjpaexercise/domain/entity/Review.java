package com.likelion.springjpaexercise.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// 항상 N 쪽에 FK가 있음
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;





}