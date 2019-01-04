package com.adrian.controller;

import com.adrian.entity.Book;
import com.adrian.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book getBookByIsbn(@PathVariable("isbn") int isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.DELETE)
    public void deleteBookByIsbn(@PathVariable("isbn") int isbn) {
        bookService.removeBookByIsbn(isbn);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertBook(@RequestBody Book book) {
        bookService.insertBook(book);
    }

}
