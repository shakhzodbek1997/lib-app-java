package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Library implements BookServiceInterface {

    private ArrayList<Member> membersDB = new ArrayList<>();
    private long personID = 1;
    private long bookID = 1;

    private ArrayList<Book> booksDB = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public Library() {

    }


    public void registerMember() {

        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter the Date of Birth: ");
        String dob = sc.nextLine();

        Member member = new Member(this.personID++, firstName, lastName, dob);

        this.membersDB.add(member);

        System.out.println("Member " + firstName + " " + lastName + " has been successfully registered");
    }

    public void getAllMembers() {
        for (Member member: this.membersDB) {
            member.getDetails();
            System.out.println();
        }
    }


    @Override
    public void addBook() {
        String title = sc.nextLine();
        String author = sc.nextLine();
        String publishedYear = sc.nextLine();
        String status = sc.nextLine();

        Book book = new Book(this.bookID++, title, author, publishedYear, status);

        this.booksDB.add(book);

        System.out.println("Book " + book.getTitle() + " has been added successfully");
    }

    @Override
    public void showAllBooks() {
        for (Book book: this.booksDB) {
            book.toString();
            System.out.println();
        }
    }

    @Override
    public void showAllAvailableBooks() {

        ArrayList<Book> allAvailableBooks = new ArrayList<>();


        for (Book book: this.booksDB) {
            if (book.getStatus() == "AVAILABLE") {
                allAvailableBooks.add(book);
            }
        }

        System.out.println("Total available books: " + allAvailableBooks.size() + "\n");
        for (Book book: allAvailableBooks) {
            book.toString();
            System.out.println();
        }

    }

    @Override
    public void borrowBook() {

    }

    @Override
    public void returnBook() {

    }
}
