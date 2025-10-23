package com.bookstore.api.exception.bookException;

public class BookCoverProcessingException extends RuntimeException {
    public BookCoverProcessingException(){
        super("Error processing book cover");
    }
}
