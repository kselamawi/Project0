package com.revature.doas;

import com.revature.model.Customer;

import java.sql.SQLException;

public interface CustomerDAO {
    public boolean createAccount(int customer_Id, String firstname, String lastname, String username, String password, int account_num, double balance);

   public void deposit(int account_num, double amount) throws SQLException;

   public  boolean getBalance(int account_num) throws SQLException;

   public void withdraw(int account_num, double amount) throws Exception;
    public void transfer(int from, int to, double amount) throws Exception;
    public boolean loginAccount(String username, String password) throws Exception;


    Customer getCustomerByUsername(String username);
}
