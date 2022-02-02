package com.revature.doas;

import com.revature.Util.ConnectionUtil;
import com.revature.model.BankAdmin;
import com.revature.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAminDAOImpl implements BankAdminDAO {

    @Override
    public BankAdmin getCustomerByUsername(String username, Connection con) throws SQLException {
        BankAdmin bankAdmin = null;
        String sql = "SELECT *FROM customer WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String Username = rs.getString("username");
            String account_num = rs.getString("account_num");
            double account_balance = rs.getDouble("balance");
            bankAdmin = new BankAdmin(username, account_num, account_balance);
        }
        return bankAdmin;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        String sql = "select *from employee";
        List<Employee> worker = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection()) {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setEmployee_id(rs.getInt("employee_id"));
                // adding customer to the arraylist
                worker.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return worker;
    }

    @Override
    public boolean deposit(int account_num, double amount) throws Exception {
        boolean success = false;
        try (Connection con = ConnectionUtil.getConnection()) {
            String sql = ("UPDATE customer SET Balance = Balance + ? WHERE account_num =?");
            Statement stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(sql);
//                pstmt.setString(1, account_num);
//                pstmt.setDouble(2, amount);
            // -trying another way
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, account_num);
            // Execute SQL statement
            int result = pstmt.executeUpdate();
            //process result
            if (result > 0) {
                System.out.println("You have deposited  successfully :\nThe AccountNumber You deposited From:"
                        + account_num + "\nAmount You deposited:" + amount + "\n");
            } else {
                System.out.println("The Account_Number or password is wrong!");
            }
        } catch (SQLException e) {
            System.out.println("An error with JDBC " + e.getMessage());
        }
        return true;
    }

    @Override
    public boolean withdraw(int account_num, double amount) throws Exception {
        boolean success = false;
        try (Connection con = ConnectionUtil.getConnection()) {
            String sql = ("UPDATE customer SET Balance = Balance - ? WHERE account_num =?");
            Statement stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(sql);
//                pstmt.setString(1, account_num);
//                pstmt.setDouble(2, amount);
            // -trying another way
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, account_num);
            // Execute SQL statement
            int result = pstmt.executeUpdate();
            //process result
            if (result > 0) {
                System.out.println("You have withdraw  successfully :\nThe AccountNumber You withdrew From:"
                        + account_num + "\nAmount You withdrew:" + amount + "\n");
            } else {
                System.out.println("The Account_Number or password is wrong!");
            }
        } catch (SQLException e) {
            System.out.println("An error with JDBC " + e.getMessage());
        }
        return true;

    }

    @Override
    public void transfer(int from, int to, double amount) throws Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            Statement st = con.createStatement();
            // withdraw operation from source account
            st.addBatch("UPDATE customer SET Balance = Balance -" + amount + "WHERE Account_Number=" + from);
            //Deposit Operation to destination account
            st.addBatch("UPDATE customer SET Balance =Balance + " + amount + "WHERE Account_Number=" + to);
            //execute the batch in Array form
            int res[] = st.executeBatch();
            // performing transaction management
            boolean flag = false;
            // may be need to check the i<res.length/ it could be i<=res.length; as well
            for (int i = 0; i < res.length; ++i) {
                System.out.println("res[" + i + "] is " + res[i]);
                if (res[i] == 0) {
                    flag = true;
                    break; // break for the for-loop not condition
                }
                if (flag == true) {
                    con.rollback();// if transaction is not completed
                    System.out.println("Transaction is rollback,Amount is not transfred");
                } else {
                    con.commit();// if transaction is completed
                    System.out.println("Transaction is committed,Amount is transferred successfully");
                }
                st.close();
                con.close();
            }
        }
    }
}












