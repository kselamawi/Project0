package com.revature.doas;

import com.revature.Util.ConnectionUtil;
import com.revature.exceptions.UnfoundedAccountNumberException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Customer;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean createAccount(String firstname, String lastname, String username, String password, int account_num, double balance) {

        try (Connection con = ConnectionUtil.getConnection()) {
//            if(findByName(firstname) !=null){
//                System.out.println("Account "+firstname+ "already exists");
//                return false;
           // }

            String sql = "INSERT INTO customer(firstname,lastname,username,password,account_num,balance) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setInt(5,account_num);
            ps.setDouble(6,balance);

            int rowUpdated = ps.executeUpdate();
            if (rowUpdated == 1) {
                System.out.println("Congratulation you have created an account:");
                System.out.println("FirstName:  "  +firstname+ "   LastName:  "  +lastname+  "  UserName  :"  +username+ "  \nPassword :  " +password+  "account_num: "  +account_num+ " Balance:  "  +balance);
                return true;

            }
            throw new UserNotFoundException("an account wasn't created");
//            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Customer customer = null;
        try (Connection con = ConnectionUtil.getConnection()) {
            String sql = "SELECT*FROM customer WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

//                String firstname = rs.getString("firstname");
//                String lastname = rs.getString("lastname");
//                String un = rs.getString("username");
//                String password = rs.getString("password");
//                double balance =rs.getDouble("balance");
//                customer = new Customer(lastname,username,password,balance);
                System.out.println("congratulation");
                return new Customer(username);
            }
            throw new UserNotFoundException("the user name you entered" + username + "not found");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public void deposit(int account_num, double amount)  {
        boolean success =false;
      try(Connection con =ConnectionUtil.getConnection()){
    String sql ="UPDATE customer SET balance = balance + ? where account_num =?";
           // stmt.executeUpdate(sql);
         Statement stmt = con.createStatement();
       PreparedStatement ps = con.prepareStatement(sql);
         //assign value to the placeholder
          ps.setDouble(1,amount);
          ps.setInt(2,account_num);
           //Excute SQL statement
          int result = ps.executeUpdate();
             //process the result
            if(result >0){
                System.out.println("Congratulation you have successfully deposited to your account");
            }else{
                System.out.println("some thing went wrong");
            }
            throw  new UserNotFoundException("account wasn't created");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return success;

    }

    @Override
    public  boolean getBalance(int account_num)  throws  SQLException{
        try(Connection con =ConnectionUtil.getConnection()){
           // String sql = "SELECT * FROM customer WHERE account_num =?";
            String sql = "SELECT * FROM customer WHERE account_num =?";

            Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,(account_num));
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
//                rs.getString("account_num");
             int balance= rs.getInt(6);
                System.out.println("Balance of the account : " +account_num+ "  = $" +balance+ "\t");
            }
        }catch (UnfoundedAccountNumberException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void withdraw(int account_num, double amount) throws Exception {
           // boolean success = false;
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
            } catch (SQLException e) {
                System.out.println("An error with JDBC " + e.getMessage());
            }
            //return success;
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
                    System.out.println("Transaction is rollback,Amount is not transefered");
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

    @Override
    public boolean loginAccount(String username, String password) throws Exception {
        try (Connection con = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer  WHERE username = ?  AND password = ?";
            Statement stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("You login to your account successfully,Welcome ");
            } else {
                System.out.println("Invalid username and password");
            }
        } catch (SQLException e) {
            System.out.println("An error with JDBC " + e.getMessage());
        }
        return false;
    }

    }






