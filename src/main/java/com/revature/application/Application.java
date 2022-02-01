package com.revature.application;

import com.revature.Util.ConnectionUtil;
import com.revature.doas.CustomerDAO;
import com.revature.doas.CustomerDAOImpl;
import com.revature.ui.MainMenu;
import com.revature.ui.Menu;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
//        try {
//            Connection connection = ConnectionUtil.getConnection();
//            System.out.println("Connected successfully to  database");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // display the main structure
          Menu mianMenu =new MainMenu();
        mianMenu.display();

//     CustomerDAO dao =new CustomerDAOImpl();
//     System.out.println(dao.CreateAccount("solomon","kahsai","kselamawi","password",5678));
//        CustomerDAO dao =new CustomerDAOImpl();
//        System.out.println(dao.createAccount());

    }
}
