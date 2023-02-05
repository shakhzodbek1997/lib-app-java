package org.example;

import java.util.ArrayList;
import java.util.List;

// this is the book service implementation class
public class ImplementServices implements BookServiceInterface{
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";
    Validator validator = new Validator();
    List<Book> books = new ArrayList<>(); // this is the list of the books, inside this list, I'm going to add all the book details

    @Override
    public void addBook() {// the logic of adding book
        String book_id = validator.validateId();
        String Author = validator.validateAuthorTitle("Author");
        String Title = validator.validateAuthorTitle("Title");
        String year = validator.validatePublishYear();
        Book book = new Book(book_id, Author, Title, year, "Available");
        books.add(book);
        System.out.println(GREEN+"Book Added Successfully!" + RESET);
    }

    @Override
    public void showAllBooks() {  // the logic of showing all books.
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%15s%15s","| ID","| TITLE","| AUTHOR","| PUBLISH YEAR","| STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        for (Book book:books){
            System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublished_Year(),book.getStatus());
            System.out.println();
            flag=true;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no Books in Library"+RESET);
    }
    @Override
    public void showAllAvailableBooks() {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%15s%15s","| ID","| TITLE","| AUTHOR","| PUBLISH YEAR","| STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        if(books.size()>0){
            for (Book book:books){
                if(book.getStatus()=="Available"){ // if books are available then shown these books only
                    System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublished_Year(),book.getStatus());
                    System.out.println();
                    flag=true;
                }
            }
        }
        else{
            System.out.println(RED+"No Books Available in the library"+RESET);
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no books with status Available"+RESET);

    }

    @Override
    public void borrowBook() {
        String book_id = validator.validateId();
        boolean flag = false;
        for (Book book:books){ // I should check, Entered book id is AVAILABLE in the library or not
            if (book.getId().equals(book_id) && book.getStatus().equals("Available")){
                flag=true;
                System.out.println(GREEN+"Book Borrowed Successfully!!! " + RESET);
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Details: "+book);
            }
        }
        if (flag == false){
            System.out.println(RED+"This book is not available to borrow"+RESET);
        }
    }

    @Override
    public void returnBook() {
        boolean flag=false;
        String book_id= validator.validateId();
        for(Book book:books){
            if(book.getId().equals(book_id) && book.getStatus().equals("Not Available")){
                flag=true;
                System.out.println(GREEN+"Book Returned Successfully !!!"+RESET);
                book.setStatus("Available");
                System.out.println("Returned Book Details: "+book);
            }
        }
        if(flag==false){
            System.out.println(RED + "We can not return this book" + RESET);
        }
    }
}

