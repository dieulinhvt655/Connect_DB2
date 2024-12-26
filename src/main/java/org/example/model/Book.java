package org.example.model;

import java.time.LocalDate;

public class Book {

    private int id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book() {
    }

    public Book(int id, String title, String author, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
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

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id: " + id +
                ", title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", publishDate: " + publishDate +
                '}';
    }
}
