package com.cache.libraryapp.services;

import com.cache.libraryapp.entities.Book;

public interface BookService  {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(String id);

    String deleteBook(String id);
}