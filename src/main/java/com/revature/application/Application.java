package com.revature.application;

import com.revature.Util.ConnectionUtil;
import com.revature.doas.CustomerDAO;
import com.revature.doas.CustomerDAOImpl;
import com.revature.model.Customer;
import com.revature.service.CustomerService;
import com.revature.service.EmployeeService;
import com.revature.ui.MainMenu;
import com.revature.ui.Menu;
import io.javalin.Javalin;
import java.sql.Connection;
import java.util.List;

public class Application {
    public static void main(String[] args) {
     /*   try {
            Connection connection = ConnectionUtil.getConnection();
            System.out.println("Connected successfully to  database");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //
            Menu mianMenu =new MainMenu();
             mianMenu.display();



















             //----Javalin----
        /*Javalin app =Javalin.create().start();
        app.get("/",ctx -> ctx.result("hello-world from Javalin"));

        // customer
        CustomerService customerService =new CustomerService();
       app.get("/Customer/{username}", ctx -> {
           String UsernameParam = ctx.pathParam("username");
           Customer customer=customerService.getCustomerByUsername(UsernameParam);
           ctx.json(customer);
       });
// get all customers
        EmployeeService employeeService =new EmployeeService();
        app.get("/customer", ctx -> {
            List<Customer> employee =employeeService.getAllCustomers();
            ctx.json(employee);
        });
        // getBalance
        app.get("/customer/{account_num}", ctx -> {
           String accParam =ctx.pathParam("account_num");
           int accNum =Integer.parseInt(accParam);
           boolean customer = customerService.getBalance(accNum);
           ctx.json(customer);
        });
*/

//        app.post("/customer/{accountnum,amount}",ctx -> {
//            String accnParam = ctx.pathParam("account");
//            int accnu =Integer.parseInt(accnParam);
//            boolean customer = customerService.deposit(accnu);
//            ctx.json(customer);
//        });
    }
}
