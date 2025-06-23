package com.ardadev.mitocodeexample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardadev.mitocodeexample.models.Book;
import com.ardadev.mitocodeexample.service.BookService;
import com.ardadev.mitocodeexample.service.BookServiceNoBd;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Esto solo crea constructores con atributos final
@RestController
@RequestMapping("/books")
public class BookController {

    //@Autowired Inyeccion de dependecia por atributo, no usual
    /**
     * Mediante Lombok generamos un constructor con el atributo de tipo
     * BookRepoNoBd que esta marcado con el esteretipo @Repository que crea
     * un Bean que pone a disposición de su instancia en este Controller.
     */
    private final BookServiceNoBd bookServiceNoBd;
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        // return ResponseEntity.noContent().build(); en caso de que retorne ResponseEntity<void>
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
    
    @GetMapping("/book-no-bd")
    public Book getBookNoBd() {
        //bookServiceNoBd = new bookServiceNoBd(); No se debe de instanciar de esta manera
        return bookServiceNoBd.getBookById(0L);
    }
}
