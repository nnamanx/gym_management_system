package org.management.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {

    Long id;
    String name;
    String surname;
    String fin;
    String serialNo;
    int departure;
    LocalDate registrationDate;
    LocalDate expirationDate;
    LocalDate updateDate;
    int paymentAmount;
    int status;

    public User(String name, String surname, String fin, String serialNo, LocalDate registrationDate, LocalDate expirationDate, int payment, int status) {
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.serialNo = serialNo;
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
        this.paymentAmount = payment;
        this.status = status;
    }

    ;

    public User(String name, String surname, int departure, int status) {
        this.name = name;
        this.surname = surname;
        this.departure = departure;
        this.status = status;
    }

    public User(String name, String surname, String fin, String serialNo, int i) {
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.serialNo = serialNo;
        this.status = i;
    }

//    public User(String name, String surname, String fin, String serialNo, DateTimeFormatter ofPattern, int status) {
//        this.name = name;
//        this.surname = surname;
//        this.fin = fin;
//        this.serialNo = serialNo;
//        this.registrationDate = registrationDate;
//        this.status = status;
//    }

    public User(String name, String surname, String fin, String serialNo, LocalDate registrationDate, int status) {

        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.serialNo = serialNo;
        this.registrationDate = registrationDate;
        this.status = status;
    }


}

