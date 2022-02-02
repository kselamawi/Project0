package com.revature.service;

import com.revature.Util.ConnectionUtil;
import com.revature.doas.EmployeeDAO;
import com.revature.doas.EmployeeDAOImpl;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Customer;
import com.revature.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
public EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employeeDAO =new EmployeeDAOImpl();

    }
    // ----list of employee
    public Customer getCustomerByCustomerId(int customer_Id) throws Exception {
       Customer customer=new Customer();
        Connection con = ConnectionUtil.getConnection();
         employeeDAO.getCustomerByCustomerId(customer_Id, con);
        if (customer_Id == 0) {
            throw new UserNotFoundException("The Customer by username '" + customer_Id + "' was not found");
        }
        con.close();
       return customer;
    }
   // ---List of-customers
  public List<Customer> getAllCustomers() throws SQLException {
      return employeeDAO.getAllCustomers();
  }

  //---- Checking customer's information
    public boolean getBalance(String username) throws Exception{
        try (Connection con = ConnectionUtil.getConnection()) {
            if ( username ==null) {
                System.out.println("the account number is incorrect");
            } else {
                employeeDAO.getBalance(username);
            }
            return false;
        }
    }
    // ---deleting an account
    public boolean deleteAccount(int account_num) throws Exception {
        boolean success=false;
        try {
            Connection con = ConnectionUtil.getConnection();
            employeeDAO.deleteAccount(account_num);
            if(success=false) {
                System.out.println("the account number:'" + account_num+ " couldn't find");
            }
            else {
                System.out.println("You have Successfully Deleted\n an account with a\n USERNAME: "+ account_num+ " from Bank account");
            }
        }catch(SQLException e) {
            System.out.println("error occurred with JDBC "+e.getMessage());
        }
        return success;

        }

    // Deposit
    public boolean deposit(int account_num, double amount) throws SQLException, Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            if (amount <= 0) {
                return false;
            } else {
                employeeDAO.deposit(account_num, amount);
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
            employeeDAO.withdraw(account_num, amount);
        }
        return true;
    }

    // get balance
   /* public boolean getBalance(int account_num) throws SQLException, Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            if (account_num == 0) {
                System.out.println("the account number is incorrect");
            } else {
                employeeDAO.getBalance(account_num);
            }
            return false;
        }*/

    // transfer funds
    public void transfer(int from, int to, double amount) throws Exception {
        employeeDAO.withdraw(from, amount);
       employeeDAO.deposit(to, amount);
    }

    }







