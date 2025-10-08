package com.bookstore.api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bookstore.api.exception.authorException.AuthorAlreadyActivated;
import com.bookstore.api.exception.authorException.AuthorAlreadyDeactivated;
import com.bookstore.api.exception.authorException.AuthorDeleteWithActiveLinkedBooks;
import com.bookstore.api.exception.authorException.AuthorNotFoundException;
import com.bookstore.api.exception.bookException.BookAlreadyActivated;
import com.bookstore.api.exception.bookException.BookAlreadyDeactivated;
import com.bookstore.api.exception.bookException.BookNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<Map<String,String>> handleGenericException(Exception ex){
        Map<String, String> error = new HashMap<>();

        error.put("message", "Something went wrong");
        error.put("status", "500");
        return ResponseEntity.status(500).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String,String>> handleNotFound(NoHandlerFoundException ex){
        
        Map<String, String> error = new HashMap<>();

        error.put("message", "The requested endpoint does not exist");
        error.put("status", "404");
        return ResponseEntity.status(404).body(error);
    }

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

    @ExceptionHandler(AuthorAlreadyDeactivated.class)
    public ResponseEntity<Map<String, String>> handlerAuthorAlreadyDeactivated(AuthorAlreadyDeactivated ex){
        
        Map<String, String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", "405");
        return ResponseEntity.status(405).body(error);
    }

    @ExceptionHandler(BookAlreadyDeactivated.class)
    public ResponseEntity<Map<String, String>> handlerBookAlreadyDeactivated(BookAlreadyDeactivated ex){
        
        Map<String, String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", "405");
        return ResponseEntity.status(405).body(error);
    }

    @ExceptionHandler({AuthorAlreadyActivated.class})
    public ResponseEntity<Map<String, String>> handlerNotFound(AuthorAlreadyActivated ex){
        
        Map<String, String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", "404");
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler({BookAlreadyActivated.class})
    public ResponseEntity<Map<String, String>> handlerNotFound(BookAlreadyActivated ex){
        
        Map<String, String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", "404");
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(AuthorDeleteWithActiveLinkedBooks.class)
    public ResponseEntity<Map<String, Object>> handlerAuthorDeleteBooks(AuthorDeleteWithActiveLinkedBooks ex){
        
        Map<String, Object> error = new HashMap<>();

        error.put("message", "Author cannot be deleted because some books are still active");
        error.put("linked_book", ex.getLinkedBooks());
        error.put("status", "405");

        return ResponseEntity.status(404).body(error);
    }
}
