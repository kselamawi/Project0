package com.revature.doas;

import com.revature.Util.ConnectionUtil;
import com.revature.exceptions.UnfoundedAccountNumberException;
import com.revature.model.Customer;
import com.revature.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements  EmployeeDAO{

    // Getting a customer by username
    @Override
    public Employee getCustomerByUsername(String employee_Id, Connection con) throws SQLException {
  Employee employee =null;
  String sql = "SELECT *FROM employee WHERE employee_Id = ?";
        PreparedStatement ps =con.prepareStatement(sql);
        ps.setString(1,employee_Id);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            String firstname =rs.getString("firstname");
            String lastname =rs.getString("lastname");
            String employeeId =rs.getString("employee_Id");
             employee =new Employee(firstname,lastname,employee_Id);
        }

        return employee;
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
             customer.getUsername(rs.getString("username"));
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
    }

