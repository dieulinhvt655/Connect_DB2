package org.example.service;

import org.example.database.Database;
import org.example.model.Book;
import org.example.service.serviceInterface.BookInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements BookInterface {

    private final Connection connection;

    public BookService() throws SQLException {
        this.connection = Database.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    //add
    @Override
    public void insertBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, published_date) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setDate(3, Date.valueOf(book.getPublished_date()));

        preparedStatement.executeUpdate();
        System.out.println("Add book successful!");
    }

    //display all book by publish date
    @Override
    public List<Book> getAllBooks() throws SQLException {
        String query = "SELECT * FROM books ORDER BY published_date DESC";
        List<Book> books = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Book book = mapRowToBook(resultSet);
            books.add(book);
        }
        return books;
    }
    public Book mapRowToBook(ResultSet resultSet) throws SQLException {
        return new Book (
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("author"),
                resultSet.getDate("published_date").toLocalDate()
                );
    }

    // update list book by id
    @Override
    public void updateBook (int id, String newTitle) throws SQLException {
        String query = "UPDATE books SET title = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newTitle);
        preparedStatement.setInt(2, id);
        int rowUpdate = preparedStatement.executeUpdate();

        if(rowUpdate > 0){
            System.out.println("Update book successful!");
        }
        else {
            System.out.println("Update book failed!");
        }
    }
    //delete
    public void deleteBook (String title) throws SQLException {
        String query = "DELETE FROM books WHERE title = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);
        int rowDelete = preparedStatement.executeUpdate();
        if(rowDelete > 0){
            System.out.println("Delete book successful!");
        }
        else {
            System.out.println("Delete book failed!");
        }
    }

}
