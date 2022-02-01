package com.revature.doas;

import com.revature.Util.ConnectionUtil;
import com.revature.exceptions.UnfoundedAccountNumberException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.BankAdmin;
import com.revature.model.Customer;
import com.revature.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAminDAOImpl implements BankAdminDAO{

    @Override
    public BankAdmin getCustomerByUsername(String username, Connection con) throws  SQLException{
        BankAdmin bankAdmin =null;
        String sql ="SELECT *FROM bank_app WHERE username = ?";
        PreparedStatement ps =con.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            String Username =rs.getString("username");
           String account_num =rs.getString("account_num");
           double account_balance =rs.getDouble("account_balance");
           bankAdmin =new BankAdmin(username,account_num,account_balance);
        }
        return bankAdmin;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        String sql ="select *from employee";
        List<Employee> worker = new ArrayList<>();
        try(Connection con = ConnectionUtil.getConnection()){
            Statement s =con.createStatement();
            ResultSet rs =s.executeQuery(sql);
            while(rs.next()){
                Employee employee =new Employee();
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setEmployee_id(rs.getString("employee_id"));
                // adding customer to the arraylist
                worker.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return worker;
    }

    @Override
    public boolean deposit(String account_num, double amount) {
        try(Connection con =ConnectionUtil.getConnection()){
            String sql = "SELECT balance FROM customer WHERE account_num =?";
            Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,account_num);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                rs.getString("account_num");
                double balance= rs.getDouble("balance");
                System.out.println("Balance of the account : " +account_num+ "\n is" +balance+ "\t");
            }
        }catch (UnfoundedAccountNumberException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }



    }

