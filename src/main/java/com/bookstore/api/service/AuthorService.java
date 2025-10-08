package com.bookstore.api.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.api.dto.authorDTO.AuthorCreateDTO;
import com.bookstore.api.dto.authorDTO.AuthorUpdateDTO;
import com.bookstore.api.exception.authorException.AuthorAlreadyActivated;
import com.bookstore.api.exception.authorException.AuthorAlreadyDeactivated;
import com.bookstore.api.exception.authorException.AuthorDeleteWithActiveLinkedBooks;
import com.bookstore.api.exception.authorException.AuthorNotFoundException;
import com.bookstore.api.model.Author;
import com.bookstore.api.model.Book;
import com.bookstore.api.repository.AuthorRepository;
import com.bookstore.api.util.ActiveObjChecker;

import jakarta.transaction.Transactional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(Boolean active){

        if (active == null) {
            return this.authorRepository.findAll();
        }

        if (active == true) {
            return this.authorRepository.findByActiveTrue();
        } else if (active == false) {
            return this.authorRepository.findByActiveFalse();
        }

        return this.authorRepository.findAll();

    }

    public Author getAuthorById(Long id){

        Optional<Author> authorOptional = this.authorRepository.findById(id);

        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(id));

        return author;

    }

    public Author registerAuthor(AuthorCreateDTO authorData){

        Author author = new Author();
        
        author.setName(authorData.name());
        author.setBirth_date(authorData.birth_date());
        author.setNationality(authorData.nationality());
        author.setActive(true);

        return this.authorRepository.save(author);

    }

    public Author updateAuthor(long id, AuthorUpdateDTO authorData) {

        Optional<Author> authorOptional = this.authorRepository.findById(id);

        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(id));
        ActiveObjChecker.isActive(author.getActive(), new AuthorAlreadyDeactivated(id));

        if (authorData.name() != null) author.setName(authorData.name());
        if (authorData.birth_date() != null) author.setBirth_date(authorData.birth_date());
        if (authorData.nationality() != null) author.setNationality(authorData.nationality());

        return this.authorRepository.save(author);

    }

    public Author activateAuthor(Long id) {
        Optional<Author> authorOptional = this.authorRepository.findById(id);

        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(id));
        ActiveObjChecker.isDeactive(author.getActive(), new AuthorAlreadyActivated(id));

        author.setActive(true);

        return this.authorRepository.save(author);
    }

    @Transactional
    public Map<Long, String> deleteAuthor(long id, Boolean force){

        Optional<Author> authorOptional = this.authorRepository.findById(id);

        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(id));
        ActiveObjChecker.isActive(author.getActive(), new AuthorAlreadyDeactivated(id));

        Map<Long, String> linked_books = author.getBooks()
        .stream().filter(Book::getActive).collect(Collectors.toMap(Book::getId, Book::getTitle));

        if (!linked_books.isEmpty()) {
            if (!Boolean.TRUE.equals(force)) {
                throw new AuthorDeleteWithActiveLinkedBooks(id, linked_books);
            } else {
                author.getBooks().stream().filter(Book::getActive).forEach(book -> {
                    book.setActive(false);
                });
            }
        }

        author.setActive(false);

        return linked_books;
    }

}
