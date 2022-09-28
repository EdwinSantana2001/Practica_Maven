package com.example.ob_rest_datajpa;

import com.example.ob_rest_datajpa.entities.Book;
import com.example.ob_rest_datajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class  ObRestDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ObRestDataJpaApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);//Probar con "BookRepository"

        //CRUD
        //crear
        Book book1 = new Book(null,"El Principito","LinuxTorvals","Sin Informacion",450,22.50, LocalDate.of(2010,12,10),true);
        Book book2 = new Book(null,"Git","LinuxTorvals","Sin Informacion",450,22.50, LocalDate.of(2010,12,10),true);
        //almacenar
        System.out.println("Numero de libro en la base de datos: "+repository.findAll().size());
        repository.save(book1);
        repository.save(book2);
        //recuperar

        System.out.println("Numero de libro en la base de datos: "+repository.findAll().size());
        //borrar
        //repository.deleteById(1L);
        System.out.println("Numero de libro en la base de datos: "+repository.findAll().size());

    }

}
