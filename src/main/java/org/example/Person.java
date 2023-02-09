package org.example;

public class Person extends GetInfo {
    private String firstName;
    private String lastName;
    private String dob;

    private long ID;

    public Person(long ID, String firstName, String lastName, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public long getID() { return ID;}

    public void setID(long ID) {this.ID = ID;}


    @Override
    public void getDetails() {
        System.out.println("ID: " + this.getID() + "\nFirst Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() + "\nDate Of Birth: " + this.getDob());
    }
}


