package com.ardadev.mitocodeexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardadev.mitocodeexample.models.Book;

/**
 * Esta clase a diferencia de las otras tiene implementado los esteretipos
 * referentes a un repositorio, de modo que la inyeccion de dependencias la
 * detectará Spring sin problemas.
 * Tambien genera la implemtación de la interface con todos los metodos CRUD
 * basicos. En los genericos van la entidad y el tipo de dato de la clave primaria. 
 */
public interface BookRepo extends JpaRepository<Book, Long> {}