package org.example.view;

public class MainMenu {

    public void Menu(){
        System.out.println("-----------------------------------");
        System.out.println("==========MENU=====================");
        System.out.println("-----------------------------------");
        System.out.println("1. Student management");
        System.out.println("2. Book management");
        System.out.println("-----------------------------------");
    }

    public void studentMenu(){
        System.out.println("-----------------------------------");
        System.out.println("----Student----");
        System.out.println("1. Add Student into Database");
        System.out.println("2. Display student information");
        System.out.println("3. Update student email by ID ");
        System.out.println("-----------------------------------");
    }

    public void bookMenu(){
        System.out.println("------------------------------------");
        System.out.println("----Book----");
        System.out.println("------------------------------------");
        System.out.println("1. Add Book into Database");
        System.out.println("2. Display book information");
        System.out.println("3. Update book title  by ID");
        System.out.println("4. Delete book by name");
        System.out.println("------------------------------------");
    }

}
