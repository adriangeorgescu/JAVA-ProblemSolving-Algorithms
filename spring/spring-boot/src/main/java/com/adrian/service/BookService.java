package com.adrian.service;

import com.adrian.dao.BookRepositoryInterface;
import com.adrian.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Qualifier("MySQL")
    private BookRepositoryInterface bookRepository;

    public BookService(BookRepositoryInterface bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Collection<Book> getAllBooks() {
        return this.bookRepository.getAllBooks();
    }

    public Book getBookByIsbn(int isbn) {
        return this.bookRepository.getBookByIsbn(isbn);
    }

    public void removeBookByIsbn(int isbn) {
        this.bookRepository.removeBookByIsbn(isbn);
    }

    public void updateBook(Book book) {
        this.bookRepository.updateBook(book);
    }

    public void insertBook(Book book) {
        this.bookRepository.insertBook(book);
    }

}
