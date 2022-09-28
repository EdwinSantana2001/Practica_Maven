package com.example.ob_rest_datajpa.controller;

import com.example.ob_rest_datajpa.entities.Book;
import com.example.ob_rest_datajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final Logger log = LoggerFactory.getLogger(BookController.class);

    BookRepository repository;
    //
    //Constructor
    public BookController(BookRepository repository) {
        this.repository = repository;
    }
    //Encontrar todos los libros


    @GetMapping("/api/books")
    public List<Book> findAll () {
        //recuperar y devolver los libros de bases de datos
        return repository.findAll();
    }


    //Buscar libro en base de datos por id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> BookId(@PathVariable Long id) {

        //Recupera e imprime por id
        Optional<Book> opciones = repository.findById(id);
        return opciones.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //return opciones.orElse(null);
        /*if (opciones.isPresent())
            return opciones.get();
        else
            return null ;*/
    }

    //Guardando
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book , @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if (book.getId() != null) {//quiere decir que existe el id por lo tanto no es una creacion
            log.warn("Triying to create a book with id");
            System.out.println("Triying to create a book with id");
            return ResponseEntity.badRequest().build();
        }else {
            Book result = repository.save(book);
            return ResponseEntity.ok(result);
        }
    }


    /**
     * Actualizar Libro existente
     * */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() == null){
            log.warn("Triying update a book non-existent");
            return ResponseEntity.badRequest().build();
        }
        if (!repository.existsById(book.getId())){
            log.warn("Triying update a book non-existent");
            return ResponseEntity.notFound().build();
        }


            //Book result = repository.save();
            return ResponseEntity.ok(book);
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if (!repository.existsById(id)){
            log.warn("Triying delete a book non-existent");
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("Ejecutando metodo BORRAR TODO");
        log.warn("Rest request deleting all books");
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
















