package com.likelion.springjpaexercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class ReviewCreateRequest {
    private Long hospitalId;
    private String userName;
    private String title;
    private String content;
}
