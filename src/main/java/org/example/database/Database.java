package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String databaseName = "students_management";
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/" + databaseName;
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseUrl, username, password) ;
    }



}
