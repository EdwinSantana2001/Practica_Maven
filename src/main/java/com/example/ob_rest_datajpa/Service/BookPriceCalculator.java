package com.example.ob_rest_datajpa.Service;

import com.example.ob_rest_datajpa.entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookPriceCalculator {
    private final Logger log = LoggerFactory.getLogger(BookPriceCalculator.class);
    public double calculatePrice(Book book){
        double price= book.getPrice();
        if (book.getPages() > 300){
        price += 5;
        }
        //envio
        log.info("Precio de envio : 5 balboas");
        price += 5;
    return price;
    }

}
