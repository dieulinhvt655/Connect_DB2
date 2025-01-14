package org.example.service.serviceInterface;

import org.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {

    void insertStudent(Student student) throws SQLException;

    List<Student> getAllStudents() throws SQLException;

    List<Student> getStudentByName(String keyword) throws SQLException;

    List<Student> getStudentSortByDateOfBirth() throws SQLException;

    void updateStudentByID (int id, String newEmail) throws SQLException;

    void deleteStudentByID (int id) throws SQLException;

    int getTotalPages(int pageSize) throws SQLException;

    List<Student> getStudentsByPage(int pageSize, int pageNumber) throws SQLException;
}
