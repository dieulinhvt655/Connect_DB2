package org.example.service.serviceInterface;

import org.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {

    void insertStudent(Student student) throws SQLException;

    List<Student> getAllStudents() throws SQLException;

    List<Student> getStudentByName() throws SQLException;

    List<Student> getStudentSortByDateOfBirth() throws SQLException;

}
