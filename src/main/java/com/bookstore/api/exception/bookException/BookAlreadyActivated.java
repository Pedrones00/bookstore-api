package com.bookstore.api.exception.bookException;

public class BookAlreadyActivated extends RuntimeException{
    public BookAlreadyActivated(Long id){
        super("Book with id " + id + " is already activate");
    }
}
