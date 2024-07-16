package com.the_library.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.the_library.controllers.BookController;
import com.the_library.models.Book;
import com.the_library.repositories.BookRepository;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    BookRepository repository;
    
    @Test
    void findAllBooksTest() throws Exception{
        Book book = new Book();
        book.setAuthor("Marcos Pacheco");
        Mockito.when(repository.findAll()).thenReturn(List.of(book));
        this.mockMvc.perform(get("/books"))
        .andDo(print())
        .andExpect(status().isOk());
        
        
        /*
        @Test
        void findAllBooks() throws Exception{
            Book book = new Book();
            book.setAuthor("Marcos Pacheco");
            Mockito.when(repository.findAll()).thenReturn(List.of(book));
            this.mockMvc.perform(get("/books"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json("[{'id':1, tittle:'Book 3',author:'Marcos Pacheco'}]"));
         
        */

    /*
    @Test
    void creatBookTest() throws Exception{
       this.mockMvc.perform(get("/books").andDo(print()).andExpect);
    }
    */
    }
}
