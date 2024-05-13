package com.cache.libraryapp.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.cache.libraryapp.entities.Book;
import com.cache.libraryapp.repository.BookRepository;



@Service
@CacheConfig(cacheNames = "book")
public class BookServiceImpl implements BookService{

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        logger.info("adding book with id - {}", book.getId());
        return bookRepository.save(book);
    }


    @Override
    @CachePut(key="#book.id")
    public Book updateBook(Book book) {
        bookRepository.updateBook(book.getId(), book.getName());
        logger.info("book updated with new name");
        return book;
    }

    @Override
    @Cacheable(key="#id")
    public Book getBook(String id) {
        logger.info("fetching book from db");
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    @Override
    @CacheEvict(key = "#id")
    public String deleteBook(String id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }

}
