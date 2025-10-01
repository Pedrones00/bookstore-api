package com.bookstore.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;

@Table(name = "books")
@Entity(name = "Book")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(length = 100)
    private String isbn;
    private int published_year;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private int stock;
    private Boolean active;
    
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToMany
    @JoinTable(
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();
    
}