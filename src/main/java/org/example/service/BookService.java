package org.example.service;

import org.example.database.Database;
import org.example.service.serviceInterface.BookInterface;

import java.sql.Connection;
import java.sql.SQLException;

public class BookService implements BookInterface {

    private final Connection connection;

    public BookService() throws SQLException {
        this.connection = Database.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }



}
