package com.diderikk.oving2.repository;

import java.util.List;
import java.util.Optional;

import com.diderikk.oving2.DAO.AuthorDAO;
import com.diderikk.oving2.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {
    @Autowired
    private AuthorDAO authorDAO;

    public List<Author> findAll(){
        return authorDAO.getAuthors();
    }

    public Optional<Author> findById(long id) {
        return Optional.of(authorDAO.getAuthorById(id));
    }

    public Author findAuthorByName(String name){
        return authorDAO.getAuthorByName(name);
    }

    public Author save(Author author){      
        if(authorDAO.insert(author) == 1) return author;
        else return null;
    }

    public Author update(long id, Author author){
        if(authorDAO.update(id, author) == 1) return author;
        else return null;
    }

    public void deleteById(long id){
        authorDAO.delete(id);
    }
}
