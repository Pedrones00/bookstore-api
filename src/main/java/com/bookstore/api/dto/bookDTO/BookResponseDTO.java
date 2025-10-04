package com.bookstore.api.dto.bookDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import com.bookstore.api.model.Book;

public record BookResponseDTO(
    Long id,
    String title,
    String isbn,
    Integer published_year,
    BigDecimal price,
    Integer stock,
    Boolean active,
    Set<Long> authors_id,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
    public BookResponseDTO(Book book){
        this(
            book.getId(),
            book.getTitle(),
            book.getIsbn(),
            book.getPublished_year(),
            book.getPrice(),
            book.getStock(),
            book.getActive(),
            book.getAuthors().stream().map(author -> author.getId()).collect(Collectors.toSet()),
            book.getCreated_at(),
            book.getUpdated_at());
    }
}
