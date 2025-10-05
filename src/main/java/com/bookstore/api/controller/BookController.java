package com.bookstore.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.api.dto.bookDTO.BookCreateDTO;
import com.bookstore.api.dto.bookDTO.BookResponseDTO;
import com.bookstore.api.dto.bookDTO.BookUpdateDTO;
import com.bookstore.api.model.Book;
import com.bookstore.api.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(@RequestParam(required = false) Boolean active){
        
        List<Book> books = this.bookService.getAllBooks(active);

        List<BookResponseDTO> booksReponse = books.stream().map(BookResponseDTO::new).toList();

        return ResponseEntity.status(200).body(booksReponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id){
        Book book = this.bookService.getBookById(id);

        return ResponseEntity.status(200).body(new BookResponseDTO(book));
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> registerBook(@RequestBody @Valid BookCreateDTO bookRequest){
        Book book = this.bookService.registerBook(bookRequest);

        return ResponseEntity.status(201).body(new BookResponseDTO(book));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody @Valid BookUpdateDTO bookRequest){
        Book book = this.bookService.updateBook(id, bookRequest);

        return ResponseEntity.status(200).body(new BookResponseDTO(book));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<BookResponseDTO> activateBook(@PathVariable Long id){
        Book book = this.bookService.activateBook(id);

        return ResponseEntity.status(200).body(new BookResponseDTO(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);

        return ResponseEntity.status(204).build();
    }

}
