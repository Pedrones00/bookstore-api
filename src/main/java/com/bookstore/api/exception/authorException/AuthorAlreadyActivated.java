package com.bookstore.api.exception.authorException;

public class AuthorAlreadyActivated extends RuntimeException {
    public AuthorAlreadyActivated(Long id){
        super("Author with id " + id + " is already activate");
    }
}
