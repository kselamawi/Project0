package com.revature.service;

import com.revature.Util.ConnectionUtil;
import com.revature.doas.CustomerDAO;
import com.revature.doas.CustomerDAOImpl;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerService {
    Scanner sc = new Scanner(System.in);
    public CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean createAccount(int customer_Id,String firstname, String lastname, String username, String password, int account_num, double balance) throws Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            customerDAO.createAccount(customer_Id,firstname, lastname, username, password, account_num, balance);
        }
        return false;
    }

    public Customer getCustomerByUsername(String username) throws UserNotFoundException, SQLException, Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            Customer customer;
            customer = customerDAO.getCustomerByUsername(username);
            if (customer == null) {
                throw new UserNotFoundException("Customer with  '" + username + "' was not found");
            }
            return customer;
        }
    }
    // Deposit
    public boolean deposit(int account_num, double amount) throws SQLException, Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            if (amount <= 0) {
                return false;
            } else {
                customerDAO.deposit(account_num, amount);
                return true;
            }

        }
    }

    //Withdraw
    public boolean withdraw(int account_num, double amount) throws Exception {
        // if(amount <=0 || amount > balance){
        if (amount <= 0) {

            return false;
        } else {
            customerDAO.withdraw(account_num, amount);
        }
        return true;
    }

    // get balance
    public boolean getBalance(int account_num) throws SQLException, Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            if (account_num == 0) {
                System.out.println("the account number is incorrect");
            } else {
                customerDAO.getBalance(account_num);
            }
            return false;
        }
    }

    // transfer funds
    public void transfer(int from, int to, double amount) throws Exception {
        customerDAO.withdraw(from, amount);
        customerDAO.deposit(to, amount);
    }

    // user login
    public boolean loginAccount(String username, String password) throws Exception {

        if (username == "" || password == null) {
            System.out.println("You need to include all fields");
            return false;
        }
return true;

    }
}

