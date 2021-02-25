package com.diderikk.oving2.DAO;

import java.util.List;

import com.diderikk.oving2.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Author getAuthorById(long id){
        String sql = "SELECT * FROM author WHERE author_id = ?";
        return jdbcTemplate.queryForObject(sql, 
        new Object[]{id},(rs, rowNum) ->
        new Author(rs.getLong("author_id"),rs.getString("author_name"),rs.getString("author_email")));
    }

    public Author getAuthorByName(String name){
        String sql = "SELECT * FROM author WHERE author_name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name},(rs, rowNum) ->
        new Author(rs.getLong("author_id"),rs.getString("author_name"),rs.getString("author_email")));
    }

    public List<Author> getAuthors(){
        String sql = "SELECT * FROM author";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
        new Author(rs.getLong("author_id"),rs.getString("author_name"),rs.getString("author_email")));
    }

    public int update(long id, Author author){
        String sql = "UPDATE author SET author_name = ?, author_email = ? WHERE author_id = ?";
        return jdbcTemplate.update(sql, new Object[]{author.getName(), author.getEmail(), id});
    }

    public int insert(Author author){
        String sql = "INSERT INTO author (author_name, author_email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, new Object[]{author.getName(), author.getEmail()});
    }

    public int delete(long id){
        String sql = "DELETE FROM author WHERE author_id = ?";
        return jdbcTemplate.update(sql,new Object[]{id});
    }
}