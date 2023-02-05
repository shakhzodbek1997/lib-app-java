package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED="\u001B[31m"; // this  is an ANSI escape code that sets the text color to red in a terminal or console.
    public static final String RESET="\u001B[0m"; // it returns the terminal text color, style, and other attributes back to their default settings.
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$"); // this pattern will match any string that contains only 1 to 4 decimal digits and nothing else
    private static Pattern AuthorTitle_Pattern=Pattern.compile("^[a-zA-Z ]+$"); //this pattern will match any string that contains only alphabetical characters and spaces, and nothing else.
    private static Pattern PublishedYear_Pattern=Pattern.compile("^\\d{4}$"); // this pattern will match any string that contains exactly 4 decimal digits and nothing else.
    Scanner sc = new Scanner(System.in);

    public String validateId(){ // the logic of validation
        String book_id;
        while (true){
            System.out.println("Enter Book ID: ");
            book_id = sc.nextLine();
            if (!ID_PATTERN.matcher(book_id).matches()){
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID BOOK ID "+RESET);
            }else {
                break;
            }
        }
        return book_id;
    }

    public String validateAuthorTitle(String input){ // This a method return to Validate AUTHOR and TITLE
        String result;
        while (true){
            if(input=="Title"){
                System.out.println("Enter Title");
            }else{
                System.out.println("Enter Author");
            }
            result=sc.nextLine();
            if(!AuthorTitle_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }
        }
        return result;
    }

    public String validatePublishYear(){
        String year;
        while(true){
            System.out.println("Enter Published Year of the Book: ");
            year=sc.nextLine();
            if(!PublishedYear_Pattern.matcher(year).matches()){
                System.out.println(RED+"Enter valid Published Year"+RESET);
            }
            else{
                break;
            }
        }
        return year;
    }
}
