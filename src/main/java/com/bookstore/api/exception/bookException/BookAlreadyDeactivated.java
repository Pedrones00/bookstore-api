package com.bookstore.api.exception.bookException;

public class BookAlreadyDeactivated extends RuntimeException{
    public BookAlreadyDeactivated(Long id){
        super("Book with id " + id + " is already deactivate");
    }
}
