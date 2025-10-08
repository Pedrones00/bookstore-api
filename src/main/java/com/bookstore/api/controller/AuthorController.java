package com.bookstore.api.controller;

import java.util.List;
import java.util.Map;

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

import com.bookstore.api.dto.authorDTO.AuthorCreateDTO;
import com.bookstore.api.dto.authorDTO.AuthorResponseDTO;
import com.bookstore.api.dto.authorDTO.AuthorResponseDeleteDTO;
import com.bookstore.api.dto.authorDTO.AuthorUpdateDTO;
import com.bookstore.api.model.Author;
import com.bookstore.api.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors(@RequestParam(required = false) Boolean active){

        List<Author> authors = this.authorService.getAllAuthors(active);

        List<AuthorResponseDTO> response = authors.stream().map(AuthorResponseDTO::new).toList();

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id){
        Author author = this.authorService.getAuthorById(id);

        return ResponseEntity.status(200).body(new AuthorResponseDTO(author));
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> registerAuthor(@RequestBody @Valid AuthorCreateDTO authorRequest){

        Author authorResponse = this.authorService.registerAuthor(authorRequest);

        return ResponseEntity.status(201).body(new AuthorResponseDTO(authorResponse));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(@PathVariable Long id, @RequestBody @Valid AuthorUpdateDTO authorRequest){
        
        Author authorResponse = this.authorService.updateAuthor(id, authorRequest);

        return ResponseEntity.status(200).body(new AuthorResponseDTO(authorResponse));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<AuthorResponseDTO> activateAuthor(@PathVariable Long id){

        Author author = this.authorService.activateAuthor(id);

        return ResponseEntity.status(200).body(new AuthorResponseDTO(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponseDeleteDTO> deleteAuthor(@PathVariable Long id, @RequestParam(required = false) Boolean force){

        Map<Long, String> linked_books = this.authorService.deleteAuthor(id, force); 

        return ResponseEntity.status(200).body(new AuthorResponseDeleteDTO(id, linked_books));
    }
    
}