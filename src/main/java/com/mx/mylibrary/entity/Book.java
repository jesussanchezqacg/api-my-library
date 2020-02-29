package com.mx.mylibrary.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity(name = "book")
@Table(name = "book", schema = "dbmylibrary")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "\"year\"", nullable = false)
    private int year;

    @Column(name = "publishing_house", nullable = false)
    private String publishingHouse;

    @Column(name = "status", insertable = false, nullable = false, columnDefinition = "NUMERIC DEFAULT 1")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean status;
}
