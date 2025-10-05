package com.bookstore.api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.bookstore.api.exception.authorException.AuthorNotFoundException;
import com.bookstore.api.exception.bookException.BookNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex){
        
        Map<String, String> error = new HashMap<>();

        if (ex.getRequiredType() == Boolean.class) {
            error.put("message", "The " + ex.getName() + " parameter must be of boolean type (true/false)");
            error.put("status", "400");
            return ResponseEntity.status(400).body(error);
        }

        error.put("message", "Error in " + ex.getPropertyName() + " parameter type.");
        error.put("status", "400");

        return ResponseEntity.status(400).body(error);
    }
    
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
