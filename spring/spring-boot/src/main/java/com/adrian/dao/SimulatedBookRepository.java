package com.adrian.dao;

import com.adrian.entity.Book;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Repository
@Qualifier("simulatedRepository")
@SuppressWarnings("unchecked")
public class SimulatedBookRepository implements BookRepositoryInterface {

    private Map<Integer, Book> books;

    public SimulatedBookRepository() {
        this.books = new HashMap<>();
        JSONParser parser = new JSONParser();

        try {
            JSONArray books = (JSONArray) parser.parse(new FileReader("src/main/resources/books.json"));

            Iterator<JSONObject> booksIterator = books.iterator();

            while (booksIterator.hasNext()) {
                JSONObject book = booksIterator.next();

                Integer isbn = Integer.parseInt(book.get("isbn").toString());
                String title = (String) book.get("title");
                String author = (String) book.get("author");

                this.books.put(isbn, new Book(isbn, title, author));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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
