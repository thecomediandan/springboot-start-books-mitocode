package com.ardadev.mitocodeexample.service;

import org.springframework.stereotype.Service;

import com.ardadev.mitocodeexample.models.Book;
import com.ardadev.mitocodeexample.models.Category;

@Service
public class BookServiceNoBdImpl implements BookServiceNoBd{

    @Override
    public Book getBookById(Long id) {
        if (id > 0) {
            return new Book(id, "El Principito", "Antoine de Saint-Exupery", new Category(1L, "Drama"));
        } else {
            return new Book(0L, "No Title", "No Author", new Category(0L, "No Category"));
        }
    }
    
}
