package com.example.ob_rest_datajpa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String editorial;
    private Integer pages;
    private Double price;
    private LocalDate relaseDate;
    private Boolean online;

    //constructores
    public Book (){}

    public Book(Long id, String title, String author, String editorial, Integer pages, Double price, LocalDate relaseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.pages = pages;
        this.price = price;
        this.relaseDate = relaseDate;
        this.online = online;
    }

    //Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(LocalDate relaseDate) {
        this.relaseDate = relaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    //To String

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", relaseDate=" + relaseDate +
                ", online=" + online +
                '}';
    }
}
