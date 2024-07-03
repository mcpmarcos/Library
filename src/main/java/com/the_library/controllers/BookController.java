package com.the_library.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the_library.models.Book;
import com.the_library.services.BookService;

@RestController
public class BookController {
    
    @Autowired
    BookService service;
    
    @PostMapping("/add")
    public ResponseEntity<String> createBook(Book book){
        return service.createBook(book);
    }
    
    @GetMapping("/books/{id}")
    public Optional<Book> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    
    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return service.findAllBooks();
    }


}
