package com.diderikk.oving2.repository;

import java.util.List;
import java.util.Optional;

import com.diderikk.oving2.DAO.BookDAO;
import com.diderikk.oving2.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @Autowired
    private BookDAO bookDAO;

    public List<Book> findAll(){
        return bookDAO.getBooks();
    }

    public Optional<Book> findById(long id) {
        return Optional.of(bookDAO.getBookById(id));
    }

    public Book findBookByTitle(String title){
        return bookDAO.getBookByTitle(title);
    }

    public Book save(Book book){      
        if(bookDAO.insert(book) == 1) return book;
        else return null;
    }

    public Book update(long id, Book book){
        if(bookDAO.update(id, book) == 1) return book;
        else return null;
    }

    public void deleteById(long id){
        bookDAO.delete(id);
    }
}
