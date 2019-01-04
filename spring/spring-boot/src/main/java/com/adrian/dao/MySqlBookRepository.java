package com.adrian.dao;

import com.adrian.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("MySQL")
public class MySqlBookRepository implements BookRepositoryInterface {

    private JdbcTemplate jdbcTemplate;

    private static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setIsbn(resultSet.getInt("isbn"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            return book;
        }
    }

    public MySqlBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Book> getAllBooks() {
        final String sql = "SELECT id, isbn, title, author FROM book";
        List<Book> books = jdbcTemplate.query(sql, new BookRowMapper());
        return books;
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        final String sql = "SELECT id, isbn, title, author FROM book WHERE isbn = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn);
        return book;
    }

    @Override
    public void removeBookByIsbn(int isbn) {
        final String sql = "DELETE FROM book WHERE isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateBook(Book book) {
        final String sql = "UPDATE book SET title = ?, author = ? WHERE isbn = ?";
        jdbcTemplate.update(sql, new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn()});
    }

    @Override
    public void insertBook(Book book) {
        final String sql = "INSERT INTO book (isbn, title, author) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{book.getIsbn(), book.getTitle(), book.getAuthor()});
    }
}
