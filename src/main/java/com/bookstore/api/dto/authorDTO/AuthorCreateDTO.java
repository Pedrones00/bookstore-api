package com.bookstore.api.dto.authorDTO;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record AuthorCreateDTO(
    
    @NotBlank(message = "Author's name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name,

    @Past(message = "Date of birth must be in the past")
    LocalDate birth_date,

    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String nationality
) {}
