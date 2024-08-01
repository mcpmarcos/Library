package com.the_library.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.the_library.DTO.BookDTO;
import com.the_library.models.Book;
import com.the_library.services.BookService;

@RestController
public class BookController {
    
    @Autowired
    BookService service;
    
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO){
        return service.createBook(bookDTO);
    }
    
    @GetMapping("/books/{id}")
    public BookDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    
    @GetMapping("/books")
    public List<BookDTO> findAllBooks() {
        return service.findAllBooks();
    }

    @GetMapping("/test")
    public String test(){
        Book book = new Book(05, "Marvel Super heroes Vs Street Fighter", "Capcom and Stam Lee");
        BookDTO bookDTO = service.createDTO(book);
        service.createBook(bookDTO);
        return book.getAuthor();
    }

}
