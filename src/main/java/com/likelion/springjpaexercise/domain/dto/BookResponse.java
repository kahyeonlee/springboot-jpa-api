package com.likelion.springjpaexercise.domain.dto;

import com.likelion.springjpaexercise.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private long bookId;
    private String bookName;
    private String authorName;

    public static BookResponse of(Book book, String authorName){
        return BookResponse.builder()
                .bookId(book.getId())
                .bookName(book.getName())
                .authorName(authorName)
                .build();
    }

}
