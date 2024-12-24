package org.example.service;

import org.example.database.Database;
import org.example.model.Student;
import org.example.service.serviceInterface.StudentInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentService implements StudentInterface {

    private final Connection connection;

    public StudentService(Connection connection) throws SQLException {
        this.connection = Database.getConnection();
    }

    //insert a student into the studentMS table
    public void insertStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, email, dateOfBirth) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        String dateOfBirth = student.getDateOfBirth().toString();
        preparedStatement.setDate(3, Date.valueOf(dateOfBirth));
        preparedStatement.executeUpdate();
        System.out.println("Add student successful!");

    }

}
