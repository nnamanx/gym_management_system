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

    public User(String name, String surname, String fin, String serialNo, LocalDate registrationDate, int status){};
    public User(String name, String surname, String fin, String serialNo, LocalDate registrationDate, LocalDate expirationDate, int payment, int status){};

    public User(String name, String surname, int departure, int status) {
    }

    public User(String name, String surname, String fin, String serialNo, int i) {
    }

    public User(String name, String surname, String fin, String serialNo, DateTimeFormatter ofPattern, int status) {
    }

    public User(String name, String surname, String fin, String serialNo, Date valueOf, int i) {
    }
}

