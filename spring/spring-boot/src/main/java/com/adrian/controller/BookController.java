package com.adrian.controller;

import com.adrian.entity.Book;
import com.adrian.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "/books"
)
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UUID create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping
    public Collection<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping(value = "/{isbn}")
    public Optional<Book> get(@NotNull @PathVariable("isbn") UUID isbn) {
        return bookService.get(isbn);
    }

    @PutMapping(value = "/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean update(@NotNull @PathVariable("isbn") UUID isbn, @NotNull @Valid @RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping(value = "/{isbn}")
    public boolean remove(@NotNull @PathVariable("isbn") UUID isbn) {
        return bookService.remove(isbn);
    }

}
