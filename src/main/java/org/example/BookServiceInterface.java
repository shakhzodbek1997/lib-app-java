package org.example;

public interface BookServiceInterface {
    void addBook();
    void showAllBooks();
    void showAllAvailableBooks();
    void borrowBook(String title);
    void returnBook(String title);
}
