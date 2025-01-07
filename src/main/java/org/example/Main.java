package org.example;

import org.example.model.Book;
import org.example.model.Student;
import org.example.service.BookService;
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
        //service
        StudentService studentService = new StudentService();
        BookService bookService = new BookService();

        MainMenu mainMenu = new MainMenu();
        SubMenu subMenu = new SubMenu();

        //hien thi menu cha
        mainMenu.Menu();
        System.out.println("Choose your choice");
        int option = scanner.nextInt();

        switch (option) {
            // student management
            case 1: {
                mainMenu.studentMenu();
                System.out.println("Choose an option: ");
                int optionStudent = scanner.nextInt();

                switch (optionStudent) {
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
                            case 0: {
                                System.out.println("Exiting program....");
                                return;
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
                        } else {
                            System.out.println("Don't delete student!");
                        }
                    }
                    // display by page
                    case 5: {

                    }
                    case 0: {
                        System.out.println("Exiting program....");
                        return;
                    }
                }
            }
            // book management
            case 2: {
                mainMenu.bookMenu();
                System.out.println("choose an option: ");
                int optionBook = scanner.nextInt();
                switch (optionBook) {
                    // add
                    case 1: {
                        scanner.nextLine();
                        System.out.println("Enter title of the book: ");
                        String title = scanner.nextLine();
                        System.out.println("Enter author of the book: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter publish date of the book (yyyy-mm-dd): ");
                        LocalDate publishDate = LocalDate.parse(scanner.nextLine());

                        Book book = new Book(title, author, publishDate);
                        bookService.insertBook(book);

                        break;
                    }
                    //display
                    case 2: {
                        System.out.println("All books in database");
                        for (Book book : bookService.getAllBooks()) {
                            System.out.println(book);
                        }
                        break;
                    }
                    //update
                    case 3: {
                        System.out.println("Enter student ID you want to update");
                        int bookID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new title of the book: ");
                        String newTitle = scanner.nextLine();

                        bookService.updateBook(bookID, newTitle);
                        break;
                    }
                    //delete
                    case 4: {
                        System.out.println("Enter title of the book you want to delete");
                        String title = scanner.nextLine();
                        bookService.deleteBook(title);
                    }
                    case 0: {
                        System.out.println("Exiting program....");
                        return;
                    }
                }
            }
            case 0: {
                System.out.println("Exiting program....");
                return;
            }
        }
    }
}