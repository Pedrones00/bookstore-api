package com.bookstore.api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bookstore.api.exception.authorException.AuthorNotFoundException;
import com.bookstore.api.exception.bookException.BookNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({AuthorNotFoundException.class})
    public ResponseEntity<Map<String, String>> handlerNotFound(AuthorNotFoundException ex){
        
        Map<String, String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", "404");
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerNotFound(BookNotFoundException ex){
        
        Map<String, String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", "404");
        return ResponseEntity.status(404).body(error);
    }
}
