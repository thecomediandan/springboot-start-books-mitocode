package com.ardadev.mitocodeexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ardadev.mitocodeexample.models.Book;
import com.ardadev.mitocodeexample.models.Category;
import com.ardadev.mitocodeexample.repository.BookRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(new Book(0L, "No Title", "No Author", new Category(0L, "No Category")));
    }

    @Override
    public Book updateBook(Long id, Book book) {
        book.setId(id);
        return bookRepo.save(book);
    }

    @Override
    public Book deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepo.delete(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

}