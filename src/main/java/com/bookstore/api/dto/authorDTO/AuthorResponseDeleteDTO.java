package com.bookstore.api.dto.authorDTO;

import java.util.Map;

public record AuthorResponseDeleteDTO(
    Long authorId,
    Map<Long, String> booksIdTitle
) {
    
}