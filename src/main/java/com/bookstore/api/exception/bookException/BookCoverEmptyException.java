package com.bookstore.api.exception.bookException;

public class BookCoverEmptyException extends RuntimeException {
    public BookCoverEmptyException(){
        super("The book cover does not exist");
    }
}