package com.example.ob_rest_datajpa.controller;

import com.example.ob_rest_datajpa.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port ;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {
        ResponseEntity<String> response = testTemplate.getForEntity("/hola", String.class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
        assertEquals("Hola Mundo que tal vamos!! Hasta luego" , response.getBody());
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> response =
                testTemplate.getForEntity("/api/books", Book[].class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
        List<Book>  books = Arrays.asList(response.getBody());
        System.out.println(books.size());

    }

    @Test
    void bookId() {
        ResponseEntity<Book> response =
                testTemplate.getForEntity("/api/books/{id}", Book.class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers =  new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String  json = """
                 "title": "Libro Hecho desde Spring Boot",
                    "author": "LinuxTorvals",
                    "editorial": "Sin Informacion",
                    "pages": 500,
                    "price": 20.10,
                    "relaseDate": "2020-12-10",
                    "online": false
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Book> response = testTemplate.exchange("/api/books", HttpMethod.POST,request,Book.class);
    }
}