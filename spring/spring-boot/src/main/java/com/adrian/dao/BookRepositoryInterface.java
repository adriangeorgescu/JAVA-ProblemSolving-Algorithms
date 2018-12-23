package com.adrian.dao;

import com.adrian.entity.Book;

import java.util.Collection;

public interface BookRepositoryInterface {
    Collection<Book> getAllBooks();

    Book getBookByIsbn(int isbn);

    void removeBookByIsbn(int isbn);

    void updateBook(Book book);

    void insertBook(Book book);

}
