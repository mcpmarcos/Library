package com.the_library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.the_library.models.Book;
import com.the_library.repositories.BookRepository;

@Service
public class BookService {

     @Autowired
    BookRepository repository;

    public ResponseEntity<String> createBook(Book book){
        repository.save(book); 
        return ResponseEntity.ok("Book created!");
    }

    public Optional<Book> findById(Integer id){
        return repository.findById(id);
    }

    public List<Book> findAllBooks(){
        return repository.findAll();
    }

    
}
