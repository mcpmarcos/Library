package com.the_library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.the_library.controllers.BookController;

@SpringBootTest
class TheLibraryApplicationTests {



	@Autowired
	private BookController controller;

	@Test
	void contextLoads() {
		assertEquals(controller, null);
	}

}
