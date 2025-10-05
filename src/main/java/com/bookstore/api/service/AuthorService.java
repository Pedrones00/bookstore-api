package com.bookstore.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.api.dto.authorDTO.AuthorCreateDTO;
import com.bookstore.api.dto.authorDTO.AuthorUpdateDTO;
import com.bookstore.api.exception.authorException.AuthorAlreadyDeactivated;
import com.bookstore.api.exception.authorException.AuthorNotFoundException;
import com.bookstore.api.model.Author;
import com.bookstore.api.repository.AuthorRepository;
import com.bookstore.api.util.ActiveObjChecker;

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

    public void deleteAuthor(long id){

        Optional<Author> authorOptional = this.authorRepository.findById(id);

        Author author = authorOptional.orElseThrow(() -> new AuthorNotFoundException(id));
        ActiveObjChecker.isActive(author.getActive(), new AuthorAlreadyDeactivated(id));

        author.setActive(false);
        
        this.authorRepository.save(author);

        return;
    }

}
