package com.adrian.dao;

import com.adrian.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySQL")
public class MySqlBookRepository implements BookRepositoryInterface {

    private JdbcTemplate jdbcTemplate;

    private static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            UUID isbn = UUID.fromString(resultSet.getString("isbn"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            int revision = resultSet.getInt("revision");
            String publishedAt = resultSet.getString("published_at");

            return new Book(id, isbn, title, author, publisher, revision, publishedAt);
        }
    }

    public MySqlBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Book> getAll() {
        final String sql = "SELECT id, isbn, title, author, publisher, revision, published_at FROM book";
        List<Book> books = jdbcTemplate.query(sql, new BookRowMapper());
        return books;
    }

    @Override
    public Optional<Book> get(UUID isbn) {
        final String sql = "SELECT id, isbn, title, author, publisher, revision, published_at FROM book WHERE isbn = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn.toString()));
    }

    @Override
    public boolean remove(UUID isbn) {
        final String sql = "DELETE FROM book WHERE isbn = ?";
        int result = jdbcTemplate.update(sql, isbn.toString());
        return result != 0;
    }

    @Override
    public boolean update(Book book) {
        final String sql = "UPDATE book SET title = ?, author = ?, publisher = ?, revision = ?, published_at = ? WHERE isbn = ?";
        int result = jdbcTemplate.update(sql, new Object[]{book.getTitle(), book.getAuthor(), book.getPublisher(), book.getRevision(), book.getPublishedAt(), book.getIsbn().toString()});
        return result != 0;

    }

    @Override
    public UUID insert(Book book) {
        final String sql = "INSERT INTO book (isbn, title, author, publisher, revision, published_at) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{book.getIsbn().toString(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getRevision(), book.getPublishedAt()});

        return book.getIsbn();
    }

}
