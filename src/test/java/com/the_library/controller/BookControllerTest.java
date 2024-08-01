package com.the_library.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.the_library.DTO.BookDTO;
import com.the_library.models.Book;
import com.the_library.services.BookService;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    BookService service;
    
    BookDTO bookDTO;
    
    List<BookDTO> bookListDTO;

    @BeforeEach
    void setup(){
        Book book1 = new Book(666,"Tiger Tiger", "José Torres"); 
        Book book2 = new Book(666,"As tranças do careca", "GBrennon");
        List<Book> books = new ArrayList<>();
        books.add(book1); 
        books.add(book2); 
        bookListDTO = service.createDTO(books);
    }

    @Test
    void returnedBookListTest() throws Exception{
        Mockito.when(service.findAllBooks()).thenReturn(bookListDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/books").contentType("APPLICATION_JSON")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
