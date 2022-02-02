package com.revature.doas;

import com.revature.Util.ConnectionUtil;
import com.revature.exceptions.UnfoundedAccountNumberException;
import com.revature.model.BankAdmin;
import com.revature.model.Customer;
import com.revature.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements  EmployeeDAO{

    // Getting a customer by username
    @Override
    public Customer getCustomerByCustomerId(int customer_Id, Connection con) throws SQLException {
  String sql = "SELECT *FROM customer WHERE customer_Id = ?";
        PreparedStatement ps =con.prepareStatement(sql);

       Customer customer=null;
//        String sql = "SELECT *FROM customer WHERE username = ?";
//        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, customer_Id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int customerId = rs.getInt("customer_Id");
            int account_num = rs.getInt("account_num");
            double balance= rs.getDouble("balance");
           customer= new Customer(customer_Id, account_num, balance);
        }
        return null;
    }

// Getting all customers
    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        String sql ="select *from customer";
        List<Customer> consumer = new ArrayList<>();
        try(Connection con = ConnectionUtil.getConnection()){
            Statement s =con.createStatement();
            ResultSet rs =s.executeQuery(sql);
            while(rs.next()){
                Customer customer =new Customer();
             customer.setFirstname(rs.getString("firstname"));
             customer.setLastname(rs.getString("lastname"));
             customer.getUsername();
             customer.setAccount_num(rs.getInt("account_num"));
             customer.setPassword(rs.getString("password"));
             customer.setBalance(rs.getDouble("balance"));
             // adding customer to the arraylist
              consumer.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consumer;


    }

    @Override
    public boolean getBalance(String username) throws SQLException {
        try(Connection con =ConnectionUtil.getConnection()){
            // String sql = "SELECT * FROM customer WHERE account_num =?";
            String sql = "SELECT * FROM customer WHERE username =?";

            Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,(username));
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
//                rs.getString("account_num");
                int balance= rs.getInt(6);
                System.out.println("Balance of the customer account with the  : " +username+  "  = $" +balance+ "\t");
            }
        }catch (UnfoundedAccountNumberException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean deleteAccount(int account_num) throws SQLException {
        boolean success =false;
        try(Connection con =ConnectionUtil.getConnection()) {

            String deleteSql ="DELETE FROM customer WHERE username= ?";
            PreparedStatement deleteAccount = con.prepareStatement(deleteSql);
            deleteAccount.setInt(1,account_num);
            deleteAccount.executeUpdate();
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public void deposit(int account_num, double amount) throws SQLException {
        try (Connection con = ConnectionUtil.getConnection()) {
            String sql = ("UPDATE customer SET Balance = Balance + ? WHERE account_num =?");
            Statement stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, account_num);
            // Execute SQL statement
            int result = pstmt.executeUpdate();
            //process result
            if (result > 0) {
                System.out.println("You havae withdrawed  successfully :\nThe AccountNumber You withdrawed From:"
                        + account_num + "\nAmount You Withdrawed:" + amount + "\n");
            } else {
                System.out.println("The Account_Number or password is wrong!");
            }
        } catch (Exception e) {
            System.out.println("An error with JDBC " + e.getMessage());
        }
    }

    @Override
    public void withdraw(int account_num, double amount) throws SQLException {
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
                System.out.println("You havae withdrawed  successfully :\nThe AccountNumber You withdrawed From:"
                        + account_num + "\nAmount You Withdrawed:" + amount + "\n");
            } else {
                System.out.println("The Account_Number or password is wrong!");
            }
        } catch (Exception e) {
            System.out.println("An error with JDBC " + e.getMessage());
        }
    }
    @Override
    public void transfer(int from, int to, double amount) throws Exception {

        try (Connection con = ConnectionUtil.getConnection()) {
            Statement st =con.createStatement();
            // withdraw operation from source account
            st.addBatch("UPDATE customer SET Balance = Balance -"+amount+ "WHERE Account_Number="+from);
            //Deposit Operation to destination account
            st.addBatch("UPDATE customer SET Balance =Balance + "+amount+ "WHERE Account_Number="+to);
            //execute the batch in Array form
            int res[]=st.executeBatch();
            // performing transaction management
            boolean flag =false;
            // may be need to check the i<res.length/ it could be i<=res.length; as well
            for(int i=0; i<res.length; ++i) {
                System.out.println("res["+i+"] is " +res[i]);
                if(res[i]==0) {
                    flag =true;
                    break; // break for the for-loop not condition
                }
                if(flag==true) {
                    con.rollback();// if transaction is not completed
                    System.out.println("Transaction is rollback,Amount is not transfred");
                }
                else
                {
                    con.commit();// if transaction is completed
                    System.out.println("Transaction is committed,Amount is transferred successfully");
                }
                st.close();
                con.close();
            }
        }
    }
}

