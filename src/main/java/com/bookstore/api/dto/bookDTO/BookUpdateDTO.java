package com.bookstore.api.dto.bookDTO;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record BookUpdateDTO(
    @Size(min = 1, max = 100)
    String title,

    @Size(min = 1, max = 100)
    String isbn,

    @PositiveOrZero
    Integer publish_year,

    @PositiveOrZero
    BigDecimal price,

    @PositiveOrZero
    Integer stock,

    Set<Long> author_ids
) {
    
}
