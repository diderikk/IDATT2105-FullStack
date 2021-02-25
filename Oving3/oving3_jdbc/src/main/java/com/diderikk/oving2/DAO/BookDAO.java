package com.diderikk.oving2.DAO;

import java.util.List;

import com.diderikk.oving2.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Book getBookById(long id){
        String sql = "SELECT * FROM book WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql, 
        new Object[]{id},(rs, rowNum) ->
        new Book(rs.getLong("book_id"),rs.getString("book_title"),rs.getInt("book_pageamount")));
    }

    public Book getBookByTitle(String title){
        String sql = "SELECT * FROM book WHERE book_title = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{title},(rs, rowNum) ->
        new Book(rs.getLong("book_id"),rs.getString("book_title"),rs.getInt("book_pageamount")));
    }

    public List<Book> getBooks(){
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
        new Book(rs.getLong("book_id"),rs.getString("book_title"),rs.getInt("book_pageamount")));
    }

    public int update(long id, Book book){
        String sql = "UPDATE book SET book_title = ?, book_pageamount = ? WHERE book_id = ?";
        return jdbcTemplate.update(sql, new Object[]{book.getTitle(), book.getPageAmount(), id});
    }

    public int insert(Book book){
        String sql = "INSERT INTO book (book_title, book_pageamount) VALUES (?, ?)";
        return jdbcTemplate.update(sql, new Object[]{book.getTitle(), book.getPageAmount()});
    }

    public int delete(long id){
        String sql = "DELETE FROM book WHERE book_id = ?";
        return jdbcTemplate.update(sql,new Object[]{id});
    }
}
