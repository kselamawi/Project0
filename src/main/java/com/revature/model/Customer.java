package com.revature.model;

import java.util.List;

public class Customer {
    private int customer_Id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private int account_num;
    private double balance;
   private List<Customer> customers;
    private Customer customer;

    public Customer() {
    }

    public Customer(int customer_Id, String firstname, String lastname, String username, String password, int account_num, double balance, Customer customer) {
        this.customer_Id = customer_Id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.account_num = account_num;
        this.balance = balance;
        this.customer = customer;
    }

    public Customer(String username) {

    }

    public Customer(int customer_id, int account_num, double balance) {
    }

    public int getCustomer_Id(int customer_Id) {
        return this.customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_num() {
        return account_num;
    }

    public void setAccount_num(int account_num) {
        this.account_num = account_num;
    }

    public double getBalance() {
        return balance;
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
                "customer_Id=" + customer_Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account_num=" + account_num +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}