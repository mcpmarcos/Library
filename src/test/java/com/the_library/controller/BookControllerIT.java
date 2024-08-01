package com.the_library.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.the_library.DTO.BookDTO;
import com.the_library.models.Book;
import com.the_library.repositories.BookRepository;
import com.the_library.services.BookService;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIT {
    
    @Autowired
    ObjectMapper mapper;
    
    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    BookRepository repository;
    
    @Autowired
    BookService service;

    BookDTO bookDTO;

    @BeforeEach
   void setup(){
   Book book = new Book(05, "Marvel Super heroes Vs Street Fighter", "Capcom and Stam Lee");
   bookDTO = service.createDTO(book);
   service.createBook(bookDTO);
  }

  @Test
  @DisplayName("Finding all books")
  void bookList() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.get("/books")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
  }

  
   // Object mapper
@Test
void createBookTestInt() throws Exception{
       
    Book book = new Book(9, "Radical Dreamers", "Kafka");
    
    String mappedBook = mapper.writeValueAsString(book);
        

    mockMvc.perform(MockMvcRequestBuilders.post("/books").contentType(MediaType.APPLICATION_JSON).content(mappedBook)).andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());

    }

    @AfterEach
    void teerDown(){
        repository.deleteAll();
    }

}
