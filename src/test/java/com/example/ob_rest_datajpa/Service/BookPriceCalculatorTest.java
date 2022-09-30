package com.example.ob_rest_datajpa.Service;

import com.example.ob_rest_datajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        //Configuracion de la prueba
        Book book = new Book(1L,"El sr de los anillos","autor","Editorial",1000,49.99, LocalDate.of(2010,11,15),true);
        BookPriceCalculator Calculator = new BookPriceCalculator();
        //Se ejecuta el comportamiento del testeo
        double price = Calculator.calculatePrice(book);
        System.out.println("El precio es: "+price);
        //Comprobaciones Acerciones
        assertTrue(price >0);
        assertEquals(59.99,price );
    }
}