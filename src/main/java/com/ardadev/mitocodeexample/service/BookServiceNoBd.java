package com.ardadev.mitocodeexample.service;

import com.ardadev.mitocodeexample.models.Book;

public interface BookServiceNoBd {
    Book getBookById(Long id);
}
