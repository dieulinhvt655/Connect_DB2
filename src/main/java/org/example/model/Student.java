package org.example.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public Student(String name, String email, LocalDate dateOfBirth) {
    }

    public Student(int id, String name, String email, LocalDate dateOfBirth) {
        this.id = this.id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", email: '" + email + '\'' +
                ", dateOfBirth: " + dateOfBirth +
                '}';
    }
}
