package com.revature.doas;

import com.revature.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
   public Customer getCustomerByCustomerId(int customer_Id, Connection con) throws SQLException;

   public List<Customer> getAllCustomers() throws  SQLException;

  public  boolean getBalance(String username) throws SQLException;

   public  boolean deleteAccount(int account_num) throws SQLException;

   public  void deposit(int account_num, double amount) throws SQLException;

   public  void withdraw(int account_num, double amount)throws SQLException;
    public void transfer(int from, int to, double amount) throws Exception;
}
