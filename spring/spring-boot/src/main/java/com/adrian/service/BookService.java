package com.adrian.service;

import com.adrian.dao.BookRepositoryInterface;
import com.adrian.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Qualifier("MySQL")
    private BookRepositoryInterface bookRepository;

    public BookService(BookRepositoryInterface bookRepository) {
        this.bookRepository = bookRepository;
    }

    public UUID create(Book book) {
        book.setIsbn(UUID.randomUUID());
        return this.bookRepository.insert(book);
    }

    public Collection<Book> getAll() {
        return this.bookRepository.getAll();
    }

    public Optional<Book> get(UUID isbn) {
        return this.bookRepository.get(isbn);
    }

    public boolean update(Book book) {
        return this.bookRepository.update(book);
    }

    public boolean remove(UUID isbn) {
        return this.bookRepository.remove(isbn);
    }

}
