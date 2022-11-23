package com.likelion.springjpaexercise.repository;

import com.likelion.springjpaexercise.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
