package org.example;

import org.example.model.Student;
import org.example.service.StudentService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, SQLException {

        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();

        System.out.println("----MENU----");
        System.out.println("1. Add Student into Database");
        System.out.println("2. Display student information");

        System.out.println("Choose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            //add student into table of database
            case 1: {
                scanner.nextLine();
                System.out.println("Enter student name: ");
                String name = scanner.nextLine();
                System.out.println("Enter student email: ");
                String email = scanner.nextLine();
                System.out.println("Enter student date of birth: ");
                System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
                scanner.next();
                String dobInput = scanner.nextLine();

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date dateOfBirth = null;
                try {
                    dateOfBirth = formatter.parse(dobInput);
                } catch (ParseException e) {
                    System.out.println("Ngày sinh không hợp lệ!");
                    return;
                }

                Student student = new Student(name, email, dateOfBirth);
                studentService.insertStudent(student);

            }
//            case 2: {
//                System.out.println("sub menu");
//                System.out.println("1. Display all students");
//                System.out.println("2. Display student by name");
//                System.out.println("3. Display student by date of birth");
//
//                System.out.println("Choose an option: ");
//                int option2 = scanner.nextInt();
//                switch (option2) {
//                    case 1: {
//
//                    }
//                }
//            }
        }


    }
}