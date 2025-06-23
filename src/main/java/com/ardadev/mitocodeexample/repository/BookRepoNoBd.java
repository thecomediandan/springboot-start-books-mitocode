package com.ardadev.mitocodeexample.repository;

import com.ardadev.mitocodeexample.models.Book;

public interface BookRepoNoBd {
    Book getBookById(Long id);
}
