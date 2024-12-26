package org.example;

import org.example.model.Student;
import org.example.service.StudentService;
import org.example.view.MainMenu;
import org.example.view.SubMenu;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, SQLException {

        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();

        MainMenu mainMenu = new MainMenu();
        SubMenu subMenu = new SubMenu();

        mainMenu.menu();
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
                System.out.println("Enter student date of birth (yyyy-mm-dd): ");
                LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

                Student student = new Student(name, email, dateOfBirth);
                studentService.insertStudent(student);

                break;
            }
            //display
            case 2: {
                subMenu.displayMenu();
                System.out.println("Choose an option: ");
                int option2 = scanner.nextInt();
                switch (option2) {
                    case 1: {
                        System.out.println("All students in database");
                        for (Student student : studentService.getAllStudents()) {
                            System.out.println(student);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Enter student name you want to display: ");
                        String keyword = scanner.nextLine();
                        System.out.println("student " + keyword + "you want to display");
                        for (Student student : studentService.getStudentByName(keyword)) {
                            System.out.println(student);
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("All students in database by date of birth");
                        for (Student student : studentService.getStudentSortByDateOfBirth()) {
                            System.out.println(student);
                        }
                        break;
                    }
                }
            }
            // update email
            case 3: {
                System.out.println("Enter student ID you want to update");
                int studentID = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter new email: ");
                String newEmail = scanner.nextLine();
                studentService.updateStudentByID(studentID, newEmail);
            }
            //delete
            case 4: {
                System.out.println("Enter student ID you want to delete");
                int studentID = scanner.nextInt();
                System.out.println("Do you want to delete student " + studentID + "? (YES/NO)");

                String answer = scanner.nextLine();
                if (answer.equals("YES")) {
                    studentService.deleteStudentByID(studentID);
                }
                else {
                    System.out.println("Don't delete student!");
                }
            }

        }
    }
}