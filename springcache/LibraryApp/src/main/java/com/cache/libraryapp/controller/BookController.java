package com.cache.libraryapp.controller;

import com.cache.libraryapp.services.BookService;
import com.cache.libraryapp.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public com.cache.libraryapp.entities.Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable String id){
        return bookService.getBook(id);
    }
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }
}
