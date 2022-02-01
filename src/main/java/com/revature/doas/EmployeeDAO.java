package com.revature.doas;

import com.revature.model.Customer;
import com.revature.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
   public  Employee getCustomerByUsername(String employee_Id, Connection con) throws SQLException;

   public List<Customer> getAllCustomers() throws  SQLException;

  public  boolean getBalance(String username) throws SQLException;
}
