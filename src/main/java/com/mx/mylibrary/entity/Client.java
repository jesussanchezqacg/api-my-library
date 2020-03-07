package com.mx.mylibrary.entity;

import lombok.Data;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "CLIENT")
@Table(name = "CLIENT", schema = "dbmylibrary")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Formula("FIRST_NAME||' '||LAST_NAME")
    private String fullName;

    @Column(name = "EDAD", nullable = false)
    private int age;

    @Column(name = "GENDER", nullable = false)
    private char gender;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Timestamp birthDate;

    @Column(name = "ADRESS", nullable = false)
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEPHONE")
    private String phone;

    @Column(name = "RFC")
    private String rfc;

    @Column(name = "CURP")
    private String curp;

    @Column(name = "STATUS", insertable = false, nullable = false, columnDefinition = "NUMERIC DEFAULT 1")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean status;
}
