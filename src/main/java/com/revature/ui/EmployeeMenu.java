package com.revature.ui;

import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

import java.util.List;

public class EmployeeMenu implements Menu {
    public EmployeeService employeeService;
    public EmployeeMenu() {
        this.employeeService =new EmployeeService();
    }

    @Override
    public void display() {
        int choice = 0;
        do {
            System.out.println("====EMPLOYEE MENU=====");
            System.out.println("1.) getEmployee by username");
            System.out.println("2.) get all customers");
            System.out.println("3.) Checking Balance");
            System.out.println("3.) Back");
            try {
                choice = Integer.parseInt(Menu.sc.nextLine());
            } catch (NumberFormatException e) {
                e.fillInStackTrace();
            }

            switch (choice) {
                case 1:
                   String employee_Id =getEmployeeIdInput();
                   try {
                       Employee employee =employeeService.getEmployeeByUsername(employee_Id);
                       System.out.println(employee);

                   } catch (Exception e){
                       System.out.println(e.getClass().getSimpleName()+ " "+e.getMessage());
                   }
                    break;
                case 2:
                    try {
                        List<Customer> employee = employeeService.getAllCustomers();
                        System.out.println(employee);
                    }catch (Exception e){
                        System.out.println(e.getClass().getSimpleName()+ " "+e.getMessage());
                    }

                case 3:
                      // Checking a customer's balance
                    String username =getCustomerInput();
                    try {
                        employeeService.getBalance(username);
                    }catch (Exception e){
                        System.out.println(e.getClass().getSimpleName()+ " "+e.getMessage());
                    }

                    break;
                case 4:
                    break;
                default:
                    System.out.println("No valid choice entered,please try again");
            }

        }while (choice != 3) ;

    }
//--- checking Customer's Balance
    private String getCustomerInput() {
        System.out.println("Get the customer username to access Balance");
        String input =sc.nextLine();
        return input;
    }

    // --getemployee
    private String getEmployeeIdInput() {
        System.out.println("enter the employee ID for the employee to trying to look");
        String input =sc.nextLine();
        return  input;
    }
}

