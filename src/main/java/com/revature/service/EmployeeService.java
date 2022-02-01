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
    public Employee getEmployeeByUsername(String employee_Id) throws Exception {
        Employee employee;
        Connection con = ConnectionUtil.getConnection();
        employee = employeeDAO.getCustomerByUsername(employee_Id, con);
        if (employee == null) {
            throw new UserNotFoundException("The Customer by username '" + employee_Id + "' was not found");
        }
        con.close();
        return employee;
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
    public void deleteAccount(int account_num) {
        if(balance =0){

        }

    }

      }





