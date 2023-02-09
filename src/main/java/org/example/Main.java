package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookServiceInterface service = new ImplementServices();

        Library library = new Library();


        do{
            System.out.println("Welcome to Book Management Application!");
            System.out.println(
                    "1. Add Book\n" +
                    "2. Show all Books\n"+
                    "3. Show Available Books\n" +
                    "4. Borrow Book\n" +
                    "5. Return Book\n" +
                    "6. Exit\n" +
                    "7. Add new member\n" +
                    "8. Get all members\n"
            );

            System.out.println("Enter Your Choice! "); // Getting choice from user
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.showAllBooks();
                    break;
                case 3:
                    service.showAllAvailableBooks();
                    break;
                case 4:
                    System.out.println("Enter the book ID: ");
                    long id = scanner.nextLong();
                    library.borrowBook(id);
                    break;
                case 5:
                    service.returnBook();
                    break;
                case 6:
                    System.out.println("Thank you For Using this Application!!!");
                    System.exit(0);
                    break;
                case 7:
                   library.registerMember();
                   break;
                case 8:
                    library.getAllMembers();
                    break;
                default:
                    System.out.println("Please Enter Valid Choice!!!");
            }
        }
        while (true);
    }
}
