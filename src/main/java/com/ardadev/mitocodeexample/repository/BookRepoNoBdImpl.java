package com.ardadev.mitocodeexample.repository;

import org.springframework.stereotype.Repository;

import com.ardadev.mitocodeexample.models.Book;
import com.ardadev.mitocodeexample.service.BookServiceNoBd;

@Repository
public class BookRepoNoBdImpl implements BookRepoNoBd {

    private BookServiceNoBd bookServiceNoBd;

    /**
     * Inyeccion de dependencias por constructor
     * Como BookServiceNoBd esta marcado como @Service, Spring lo va a inyectar
     * porque se guarda un Bean para su disponibilidad.
     * @param bookServiceNoBd
     */
    public BookRepoNoBdImpl(BookServiceNoBd bookServiceNoBd) {
        this.bookServiceNoBd = bookServiceNoBd;
    }

    @Override
    public Book getBookById(Long id) {
        // bookServiceNoBd = new BookServiceNoBdImpl(); No se debe de instanciar de esta manera
        return bookServiceNoBd.getBookById(id);
    }
    
}
