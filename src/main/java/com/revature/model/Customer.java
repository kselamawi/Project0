package com.revature.model;

public class Customer {
    private String FirstName;
    private String LastName;
    private int Age;
    private String Address;

    public Customer(String firstName, String lastName, int age, String address) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Address = address;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
