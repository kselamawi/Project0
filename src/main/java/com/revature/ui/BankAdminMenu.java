package com.revature.ui;

import com.revature.model.BankAdmin;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.service.BankAdminService;

import java.util.List;

public class BankAdminMenu implements Menu {
    public BankAdminService bankAdminService;

    public BankAdminMenu() {
        this.bankAdminService = new BankAdminService();
    }

    @Override
    public void display() {
        int choice = 0;
        do {
            System.out.println("=======BANKADMIN MENU====");
            System.out.println("1.) get All Employee ");
            System.out.println("2.) get Customer information");
            System.out.println("3.) Cancel Account ");
            System.out.println("4.) Withdraw from an account");
            System.out.println("5.) Deposit to an Account ");
            System.out.println("6.) Transfer from an Account ");
            System.out.println("7.) Back");
            try {
                choice = Integer.parseInt(Menu.sc.nextLine());
            } catch (NumberFormatException e) {
                e.fillInStackTrace();
            }
            switch (choice) {
                case 1:
                    try {
                        List<Employee> bankAdmin = bankAdminService.getAllEmployee();
                        System.out.println(bankAdmin);
                    }catch (Exception e){
                        System.out.println(e.getClass().getSimpleName()+ " "+e.getMessage());
                    }

                    break;
                case 2:
                    //customer information
                    String username =getCustomerUSername();
                    try{
                        BankAdmin bankAdmin =bankAdminService.getCustomerByUsername(username);
                        System.out.println(bankAdmin);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    //cancel an account
                    break;
                case 4:
                    //withdraw from an account
                case 5:
                    // Deposit to an account
                    String account_num =getAccountNumberInput();
                    double amount = getAmountInput();

                    try {
                        bankAdminService.deposit(account_num, amount);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getClass() + " " + e.getMessage());
                    }
                    break;
                case 6:
                    //Transfer from an account
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid entry,please try again");
            }
        }while (choice != 7) ;

    }
// deposit
    private double getAmountInput() {
        System.out.println("Enter the amount you would like to deposit");
        double input =sc.nextDouble();
        return input;
    }

    private String getAccountNumberInput() {
        System.out.println("Enter the account you would like to deposit ");
        String input =sc.nextLine();
        return input;

    }

    //add
    private String getCustomerUSername() {
        System.out.println("enter the username of the customer you trying to get information");
        String input =sc.nextLine();
        return input;
    }
}
