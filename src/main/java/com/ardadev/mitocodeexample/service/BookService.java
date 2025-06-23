package com.ardadev.mitocodeexample.service;

import java.util.List;

import com.ardadev.mitocodeexample.models.Book;

public interface BookService {
    Book saveBook(Book book);
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    Book deleteBook(Long id);
    List<Book> getAllBooks();
}
