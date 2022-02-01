package com.revature.service;

import com.revature.Util.ConnectionUtil;
import com.revature.doas.BankAdminDAO;
import com.revature.doas.BankAminDAOImpl;
import com.revature.doas.CustomerDAO;
import com.revature.doas.CustomerDAOImpl;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.BankAdmin;
import com.revature.model.Customer;
import com.revature.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankAdminService {
    public BankAdminDAO bankAdminDAO = new BankAminDAOImpl();

    /// customer information method
    public BankAdmin getCustomerByUsername(String username) throws UserNotFoundException, Exception {
        BankAdmin bankAdmin;
        Connection con = ConnectionUtil.getConnection();
        bankAdmin = bankAdminDAO.getCustomerByUsername(username, con);
        if (bankAdmin == null) {
            throw new UserNotFoundException("Customer with username '" + username + "' was not found");
        }
        return bankAdmin;
    }

    public List<Employee> getAllEmployee() throws SQLException {
        return bankAdminDAO.getAllEmployee();

    }


    public boolean deposit(String account_num, double amount) throws SQLException, Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            if (amount <= 0) {
                return false;
            } else {
                bankAdminDAO.deposit(account_num, amount);
                return true;
            }

        }
    }
}






//    public  void closeAccount(String username) throws SQLException{
//        try (Connection con = ConnectionUtil.getConnection()) {
//
//
//        }
//
//    }





