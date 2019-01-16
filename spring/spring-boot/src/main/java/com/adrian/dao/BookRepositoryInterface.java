package com.adrian.dao;

import com.adrian.entity.Book;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface BookRepositoryInterface {
    Collection<Book> getAll();

    Optional<Book> get(UUID isbn);

    boolean remove(UUID isbn);

    boolean update(Book book);

    UUID insert(Book book);

}
