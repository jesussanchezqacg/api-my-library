package com.mx.mylibrary.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity(name = "BOOK")
@Table(name = "BOOK", schema = "dbmylibrary")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "ANO", nullable = false)
    private int year;

    @Column(name = "PUBLISHING_HOUSE", nullable = false)
    private String publishingHouse;

    @Column(name = "STATUS", insertable = false, nullable = false, columnDefinition = "NUMERIC DEFAULT 1")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean status;
}
