package com.mx.mylibrary.entity;

import lombok.Data;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "client")
@Table(name = "client", schema = "dbmylibrary")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Formula("name||' '||lastName")
    private String fullName;

    @Column(name = "\"age\"", nullable = false)
    private int age;

    @Column(name = "gender", nullable = false)
    private char gender;

    @Column(name = "birth_date", nullable = false)
    private Timestamp birthDate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "rfc")
    private String rfc;

    @Column(name = "curp")
    private String curp;

    @Column(name = "status", insertable = false, nullable = false, columnDefinition = "NUMERIC DEFAULT 1")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean status;
}
