package com.the_library.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.the_library.DTO.BookDTO;
import com.the_library.models.Book;
import com.the_library.repositories.BookRepository;

@Service
public class BookService {

     @Autowired
    BookRepository repository;

    public ResponseEntity<Book> createBook(BookDTO bookDTO){
        Book book = new Book(bookDTO.id(), bookDTO.tittle(), bookDTO.author());
        repository.save(book); 
        return ResponseEntity.status(HttpStatus.CREATED).body(book);

    }

    public BookDTO findById(Integer id){
        Book book = repository.findById(id).get();
        return createDTO(book);
    }

    public List<BookDTO> findAllBooks(){
        List<Book> books = repository.findAll();
        return createDTO(books);
    }

    public BookDTO createDTO(Book book){
        BookDTO bookDTO = new BookDTO(book.getId(), book.getTittle(), book.getAuthor());
        return bookDTO;
    }

    public List<BookDTO> createDTO(List<Book> books){
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {        
            BookDTO bookDTO = new BookDTO(book.getId(), book.getTittle(), book.getAuthor());
            bookDTOs.add(bookDTO);
        }
        return bookDTOs;
    }
}
