package com.bookstore.api.repository;

import com.bookstore.api.model.Author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByActiveTrue();
    List<Author> findByActiveFalse();
}