package com.bookstore.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Table(name = "authors")
@Entity(name = "Author")
public class Author {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String name;
    private LocalDate birth_date;

    @Column(length = 100)
    private String nationality;
    private Boolean active;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
