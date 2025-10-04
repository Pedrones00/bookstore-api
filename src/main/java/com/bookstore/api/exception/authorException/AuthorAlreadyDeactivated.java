package com.bookstore.api.exception.authorException;

public class AuthorAlreadyDeactivated extends RuntimeException {
    public AuthorAlreadyDeactivated(Long id){
        super("Author with id " + id + " is already deactivate");
    }
}
