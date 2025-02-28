package org.example.service;

import org.example.database.Database;
import org.example.model.Student;
import org.example.service.serviceInterface.StudentInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentInterface {

    private final Connection connection;

    public StudentService() throws SQLException {
        this.connection = Database.getConnection();
    }

    //insert a student into the studentMS table
    @Override
    public void insertStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, email, dateOfBirth) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.executeUpdate();
        System.out.println("Add student successful!");

    }

    //select all student
    @Override
    public List<Student> getAllStudents() throws SQLException {
        String query = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Student student = mapRowToStudent(resultSet);
            students.add(student);
        }

        return students;
    }

    //Chỉ hiển thị học viên có tên chứa từ "Nguyen"
    @Override
    public List<Student> getStudentByName(String keyword) throws SQLException {
        String query = "SELECT * FROM students WHERE name LIKE ?";
        List<Student> students = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Student student = mapRowToStudent(resultSet);
            students.add(student);
        }

        return students;
    }

    //Hiển thị danh sách học viên theo thứ tự ngày sinh tăng dần.
    @Override
    public List<Student> getStudentSortByDateOfBirth() throws SQLException {
        String query = "SELECT * FROM students ORDER BY dateOfBirth ASC";
        List<Student> students = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Student student = mapRowToStudent(resultSet);
            students.add(student);
        }

        return students;
    }

    public Student mapRowToStudent (ResultSet resultSet) throws SQLException {
        return new Student (
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getDate("dateOfBirth").toLocalDate()
        );
    }

    @Override
    public void updateStudentByID (int id, String newEmail) throws SQLException {
        String query = "UPDATE students SET email = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newEmail);
        preparedStatement.setInt(2, id);

        int rowUpdate = preparedStatement.executeUpdate();

        if (rowUpdate > 0) {
            System.out.println("Update student successful!");
        }
        else {
            System.out.println("Update student failed!");
        }
    }

    @Override
    public void deleteStudentByID (int id) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        int rowDelete = preparedStatement.executeUpdate();

        if (rowDelete > 0) {
            System.out.println("Delete student successful!");
        }
        else {
            System.out.println("Delete student failed!");
        }
    }



    @Override
    public int getTotalPages(int pageSize) throws SQLException {
        String query = "SELECT COUNT(*) FROM students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int totalStudents = resultSet.getInt(1);
            return (int) Math.ceil((double) totalStudents / pageSize);
        }
        return 0;
    }

    @Override
    public List<Student> getStudentsByPage(int pageSize, int pageNumber) throws SQLException {
        List<Student> students = new ArrayList<>();
        int offset = (pageNumber - 1) * pageSize;

        String query = "SELECT * FROM students LIMIT ? OFFSET ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, offset);
        preparedStatement.setInt(2, pageSize);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = mapRowToStudent(resultSet);
            students.add(student);
        }
        return students;
    }



}
