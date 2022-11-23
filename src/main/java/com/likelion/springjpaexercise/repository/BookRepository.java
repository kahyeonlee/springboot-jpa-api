package com.likelion.springjpaexercise.repository;

import com.likelion.springjpaexercise.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
