package com.bookstore.api.exception.authorException;

import java.util.Map;

public class AuthorDeleteWithActiveLinkedBooks extends RuntimeException {
    
    private Long authorId;
    private Map<Long, String> linkedBooks;

    public AuthorDeleteWithActiveLinkedBooks(Long authorId, Map<Long, String> linkedBooks){
        this.authorId = authorId;
        this.linkedBooks = linkedBooks;
    }
    
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Map<Long, String> getLinkedBooks() {
        return linkedBooks;
    }

    public void setLinkedBooks(Map<Long, String> linkedBooks) {
        this.linkedBooks = linkedBooks;
    }
    
}
