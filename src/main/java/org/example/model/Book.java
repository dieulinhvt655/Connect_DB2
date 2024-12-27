package org.example.model;

import java.time.LocalDate;

public class Book {

    private int id;
    private String title;
    private String author;
    private LocalDate published_date;

    public Book(String title, String author, LocalDate publishDate) {
    }

    public Book(int id, String title, String author, LocalDate published_date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.published_date = published_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublished_date() {
        return published_date;
    }

    public void setPublished_date(LocalDate published_date) {
        this.published_date = published_date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id: " + id +
                ", title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", publishDate: " + published_date +
                '}';
    }
}
