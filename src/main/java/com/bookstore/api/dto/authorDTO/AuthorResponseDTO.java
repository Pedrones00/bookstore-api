package com.bookstore.api.dto.authorDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bookstore.api.model.Author;

public record AuthorResponseDTO(
    Long id,
    String name,
    LocalDate birth_date,
    String nationality,
    Boolean active,
    LocalDateTime created_at,
    LocalDateTime update_at
) {
    public AuthorResponseDTO(Author author){
        this(author.getId(), author.getName(), author.getBirth_date(), author.getNationality(), author.getActive(), author.getCreated_at(), author.getUpdate_at());
    }
}