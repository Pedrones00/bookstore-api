package com.bookstore.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.api.dto.bookDTO.BookCreateDTO;
import com.bookstore.api.dto.bookDTO.BookUpdateDTO;
import com.bookstore.api.exception.authorException.AuthorAlreadyDeactivated;
import com.bookstore.api.exception.authorException.AuthorNotFoundException;
import com.bookstore.api.exception.bookException.BookAlreadyDeactivated;
import com.bookstore.api.exception.bookException.BookNotFoundException;
import com.bookstore.api.model.Author;
import com.bookstore.api.model.Book;
import com.bookstore.api.repository.AuthorRepository;
import com.bookstore.api.repository.BookRepository;
import com.bookstore.api.util.ActiveObjChecker;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks(Boolean active){
        
        if(active == null){
            return this.bookRepository.findAll();
        } else if (active == true) {
            return this.bookRepository.findByActiveTrue();
        } else if (active == false) {
            return this.bookRepository.findByActiveFalse();
        }

        return this.bookRepository.findAll();
        
    }

    public Book getBookById(Long id){
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        Book book = optionalBook.orElseThrow(() -> new BookNotFoundException(id));

        return book;
    }

	public Book registerBook(BookCreateDTO bookData) {
		Book book = new Book();

        book.setTitle(bookData.title());
        book.setIsbn(bookData.isbn());
        book.setPublished_year(bookData.publish_year());
        book.setPrice(bookData.price());
        book.setStock(bookData.stock());
        book.setActive(true);
        Set<Author> authors = bookData.author_ids()
                                .stream()
                                .map(author_id -> this.authorRepository.findById(author_id)
                                .orElseThrow(() -> new AuthorNotFoundException(author_id)))
                                .peek(author -> ActiveObjChecker.isActive(author.getActive(), new AuthorAlreadyDeactivated(author.getId())))
                                .collect(Collectors.toSet());
        book.getAuthors().addAll(authors);

        return this.bookRepository.save(book);
	}

    public Book updateBook(Long id, BookUpdateDTO bookData){
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        Book book = optionalBook.orElseThrow(() -> new BookNotFoundException(id));
        ActiveObjChecker.isActive(book.getActive(), new BookAlreadyDeactivated(id));
        
        if (bookData.title() != null) book.setTitle(bookData.title());
        if (bookData.isbn() != null) book.setIsbn(bookData.isbn());
        if (bookData.publish_year() != null) book.setPublished_year(bookData.publish_year());
        if (bookData.price() != null) book.setPrice(bookData.price());
        if (bookData.stock() != null) book.setStock(bookData.stock());
        if (bookData.author_ids() != null) {
            Set<Author> authors = bookData.author_ids()
                                .stream()
                                .map(author_id -> this.authorRepository.findById(author_id)
                                .orElseThrow(() -> new AuthorNotFoundException(author_id)))
                                .peek(author -> ActiveObjChecker.isActive(author.getActive(), new AuthorAlreadyDeactivated(author.getId())))
                                .collect(Collectors.toSet());

            book.getAuthors().clear();
            book.getAuthors().addAll(authors);
        }

        return this.bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        Book book = optionalBook.orElseThrow(() -> new BookNotFoundException(id));

        ActiveObjChecker.isActive(book.getActive(), new BookAlreadyDeactivated(id));

        book.setActive(false);

        this.bookRepository.save(book);

        return;
    }



}
