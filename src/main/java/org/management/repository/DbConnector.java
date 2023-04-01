package org.management.repository;

import org.management.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbConnector {

    public Connection connectDb () throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/management";
        String username = "postgres";
        String password = "12131";

        return DriverManager.getConnection(url, username, password);
    }


    public abstract boolean updateDeparture(Long id, User user);
}
