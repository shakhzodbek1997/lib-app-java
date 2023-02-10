package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    library.addBook();
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    library.showAllAvailableBooks();
                    break;
                case 4:
                    System.out.print("Enter the book title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case 5:
                    System.out.print("Enter the book title: ");
                    scanner.nextLine();
                    String currTitle = scanner.nextLine();
                    library.returnBook(currTitle);
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
