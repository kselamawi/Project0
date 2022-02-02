package com.revature.ui;

import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

import java.util.List;

public class EmployeeMenu implements Menu {
    public EmployeeService employeeService;

    public EmployeeMenu() {
        this.employeeService = new EmployeeService();
    }

    @Override
    public void display() {
        int choice = 0;
        do {
            System.out.println("====EMPLOYEE MENU=====");
            System.out.println("1.) get Customer by Customer_Id");
            System.out.println("2.) get all customers");
            System.out.println("3.) Checking Balance");
            System.out.println("4.) Delete Account");
            System.out.println("5.) Deposit to Account");
            System.out.println("6.) Withdraw from Account");
            System.out.println("7.) Transfer fund");
            System.out.println("8.) Back");
            try {
                choice = Integer.parseInt(Menu.sc.nextLine());
            } catch (NumberFormatException e) {
                e.fillInStackTrace();
            }

            switch (choice) {
                case 1:
                    int customer_Id = getCustomerIdInput();
                    try {
                        employeeService.getCustomerByCustomerId(customer_Id);
                    } catch (Exception e) {
                        System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        List<Customer> employee = employeeService.getAllCustomers();
                        System.out.println(employee);
                    } catch (Exception e) {
                        System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
                    }

                case 3:
                    // Checking a customer's balance
                    String username = getCustomerInput();
                    try {
                        employeeService.getBalance(username);
                    } catch (Exception e) {
                        System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
                    }
                    break;
                case 4:
                    // delete an account
                    int account_num = getAccountNumInput();
                    try {
                        employeeService.deleteAccount(account_num);
                    } catch (Exception e) {
                        System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
                    }
                        break;

                    case 5:
                            // Deposit
                            int acct =getAccountNumToDeposit();
                            double amount =getAmountToDeposit();
                            try{
                                employeeService.deposit(acct,amount);

                            }catch (Exception e){
                                System.out.println(e.getClass()+" "+e.getMessage());
                            }
                            break;
                case 6:
                    //Withdraw
                    int Acc =getAccountNumToWithdraw();
                    double amt =getAmmountInputToWithdraw();
                    try {
                        employeeService.withdraw(Acc,amt);
                    }catch (Exception e){
                        System.out.println(e.getClass() + " "+e.getMessage());
                    }
                    break;
                case 7:
                    //Transfer fund
                    int src =getSourceAccountNum();
                    int des =getDestinationAccountNum();
                    double aamount =getAmountYouTransfering();
                    try{
                        employeeService.transfer(src,des,aamount);
                    }catch (Exception e){
                        System.out.println(e.getClass() +""+e.getMessage());
                    }
                    break;
                case 8:
                        break;

                        default:
                            System.out.println("No valid choice entered,please try again");
                    }

        } while (choice != 8);
    }

    private int getCustomerIdInput() {
        System.out.println("enter the customer Id you want to look at ");
        int input =sc.nextInt();
        return input;
    }

    //Transfer funds
    private double getAmountYouTransfering() {
        System.out.println("Enter the amount you want to transfer to another account number");
        double input =sc.nextDouble();
        return input;
    }

    private int getDestinationAccountNum() {
        System.out.println("Enter the Your destination account number ");
        int input =sc.nextInt();
        return input;
    }

    private int getSourceAccountNum() {
        System.out.println("Enter the source from where you're withdrawing");
        int input =sc.nextInt();
        return input;
    }

    //withdraw
    private double getAmmountInputToWithdraw() {
        System.out.println("Enter the amount to withdraw");
        double input =sc.nextDouble();
        return input;
    }

    private int getAccountNumToWithdraw() {
        System.out.println("enter the account number you're withdrawing from");
        int input = sc.nextInt();
        return input;
    }


    // deposit
    private double getAmountToDeposit() {
        System.out.println("Enter the amount you would like to deposit");
        double input =sc.nextDouble();
        return input;
    }
    private int getAccountNumToDeposit() {
        System.out.println("Enter the account number you're depositing to");
        int input =sc.nextInt();
        return input;
    }

    private int getAccountNumInput() {
        System.out.println("enter the account number you want to delete");
        int acct =sc.nextInt();
        return acct;

    }

    private String getCustomerInput() {
        System.out.println("enter the customer username you want to look at");
        String string =sc.nextLine();
        return string;
    }

    private int getEmployeeIdInput() {
        System.out.println("Enter the employee Id you want to look at");
        int input =sc.nextInt();
        return input;

    }
}

