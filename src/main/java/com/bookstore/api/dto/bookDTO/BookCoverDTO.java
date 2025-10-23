package com.bookstore.api.dto.bookDTO;

import com.bookstore.api.model.Book;

public record BookCoverDTO(
    String fileType,
    byte[] binary
){
    public BookCoverDTO(Book book){
        this(book.getBook_cover_file_type(), book.getBook_cover_file());
    }
}