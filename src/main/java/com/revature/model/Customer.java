package com.revature.model;

import java.util.Objects;

public class Customer {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private int account_num;
    private double balance;
//    private List<Customer> customerList;
    private Customer customer;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String username, String password, int account_num, double balance, Customer customer) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.account_num = account_num;
        this.balance = balance;
        this.customer = customer;
    }

    public Customer( String username){
    }

    public Customer(Comparable<String> lastname, Comparable<String> username, Comparable<String> stringComparable, double balance) {
    }

    public String getFirstname(String firstname) {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(String lastname) {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername(String username) {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_num(int account_num) {
        return this.account_num;
    }

    public void setAccount_num(int account_num) {
        this.account_num = account_num;
    }

    public double getBalance(String balance) {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account_num='" + account_num + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer1 = (Customer) o;
        return Double.compare(customer1.balance, balance) == 0 && Objects.equals(firstname, customer1.firstname) && Objects.equals(lastname, customer1.lastname) && Objects.equals(username, customer1.username) && Objects.equals(password, customer1.password) && Objects.equals(account_num, customer1.account_num) && Objects.equals(customer, customer1.customer);
    }
}