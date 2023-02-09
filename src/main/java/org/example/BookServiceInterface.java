package org.example;

public interface BookServiceInterface {
    void addBook();
    void showAllBooks();
    void showAllAvailableBooks();
    void borrowBook(long ID);
    void returnBook();
}
