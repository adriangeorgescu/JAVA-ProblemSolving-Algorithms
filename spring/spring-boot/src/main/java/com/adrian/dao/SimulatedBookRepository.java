package com.adrian.dao;

import com.adrian.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("simulatedRepository")
public class SimulatedBookRepository implements BookRepositoryInterface {

    private static Map<Integer, Book> books;

    static {
        books = new HashMap<Integer, Book>() {
            {
                put(1, new Book(1, "In search of Lost Time", "Marcel Proust"));
                put(2, new Book(2, "Ulysses", "James Joyce"));
                put(3, new Book(3, "Don Quixote", "Miguel de Cervantes"));
                put(4, new Book(4, "Moby Dick", "Herman Melville"));
                put(5, new Book(5, "Hamlet", "William Shakespeare"));
                put(6, new Book(6, "War and Peace", "Leo Tolstoy"));
            }
        };
    }

    @Override
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        return books.get(isbn);
    }

    @Override
    public void removeBookByIsbn(int isbn) {
        books.remove(isbn);
    }

    @Override
    public void updateBook(Book book) {
        Book b = books.get(book.getIsbn());
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        books.put(book.getIsbn(), b);
    }

    @Override
    public void insertBook(Book book) {
        books.put(book.getIsbn(), book);
    }
}
