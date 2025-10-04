package com.bookstore.api.dto.bookDTO;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record BookCreateDTO(
    @NotBlank
    String title,

    @NotBlank
    String isbn,

    @NotNull
    Integer publish_year,

    @NotNull
    @PositiveOrZero
    BigDecimal price,

    @NotNull
    @PositiveOrZero
    Integer stock,

    @NotNull
    Set<Long> author_ids
) {}
