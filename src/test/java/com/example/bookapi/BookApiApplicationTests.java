package com.example.bookapi;

import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookApiApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private BookService bookService;

    @Test
    public void getAllBooks_ShouldReturnBooks() {
        // Arrange
        Book book1 = new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book(2L, "To Kill a Mockingbird", "Harper Lee");
        List<Book> books = Arrays.asList(book1, book2);

        when(bookService.getAllBooks()).thenReturn(books);

        // Act
        String url = "http://localhost:" + port + "/api/books";
        ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody()[0].getTitle()).isEqualTo("The Great Gatsby");
        assertThat(response.getBody()[1].getTitle()).isEqualTo("Kill aaa Mockingbird");
    }
}
