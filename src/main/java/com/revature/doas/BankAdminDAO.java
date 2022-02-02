package com.revature.doas;

import com.revature.model.BankAdmin;
import com.revature.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BankAdminDAO {
    public BankAdmin getCustomerByUsername(String username, Connection con) throws SQLException;

   public  List<Employee> getAllEmployee() throws SQLException;

   public  boolean deposit(int account_num, double amount) throws Exception;

   public boolean withdraw(int account_num, double amount) throws Exception;

    public void transfer(int from, int to, double amount) throws Exception;
}
