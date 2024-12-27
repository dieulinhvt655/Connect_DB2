package org.example.service.serviceInterface;

import org.example.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookInterface {

    void insertBook(Book book) throws SQLException;

    List<Book> getAllBooks() throws SQLException;

    void updateBook (int id, String newTitle) throws SQLException;
}
