package com.revature.ui;

import com.revature.model.Customer;
import com.revature.service.CustomerService;

public class CustomerMenu implements Menu {
public CustomerService customerService;

    public CustomerMenu() {
        this.customerService = new CustomerService();
    }

    @Override
    public void display() {
        int choice = 0;
        do {
            System.out.println("=====CUSTOMER MENU====");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|        Welcome to Mr.S's                             |");
            System.out.println("|        Excellent Bank App                            |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("pLease select an option below");
            System.out.println("1.) Create an account");
            System.out.println("2.) getCustomerByUsername");
            System.out.println("3.) Deposit to an account ");
            System.out.println("4.) Withdraw from an account");
            System.out.println("5.) getBalance");
            System.out.println("6.) Transfer");
            System.out.println("7.) LoginAccount");
            System.out.println("8.) Back");
            try {
                choice = Integer.parseInt(Menu.sc.nextLine());
            } catch (NumberFormatException e) {
                e.fillInStackTrace();
            }
            switch (choice) {
                case 1:
                    // create an account
                    String firstname = getFirstnameInput();
                    String lastname = getLastnameInput();
                    String UserName = getUsernameInput();
                    String password = getPasswordInput();
                    int account_num = getAccountNumInput();
                    double balance = getBalanceInput();
                    try {
                        customerService.createAccount(firstname, lastname, UserName, password,account_num ,balance);
                        System.out.println();
                    } catch (Exception e) {
                        e.fillInStackTrace();
                    }
                    break;
                case 2:
                    String username = gettingUsernameInput();
                    try {
                        Customer customer = customerService.getCustomerByUsername(username);
                        System.out.println(customer);
                    } catch (Exception e) {
                        System.out.println(e.getClass().getClass() + " " + e.getMessage());
                    }
                    break;
                case 3:
                    //deposit
                    int accNum = gettingAccountToDeposit();
                    double Amount = gettingAmountInput();

                    try {
                        customerService.deposit(accNum, Amount);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getClass() + " " + e.getMessage());
                    }
                    break;
                case 4:
                    //withdraw
                    int acc_num = gettingAccNumWithdrawFrom();
                    double amount = getAmountInput();
                    try{
                        customerService.withdraw(acc_num,amount);
                    }catch (Exception e){
                        System.out.println("the account number you entered is not found");
                    }
                    break;
                case 5:
                    // Get Balance
                    int accountNum = gettingBalanceInput();
                    try {
                        customerService.getBalance(accountNum);

                    } catch (Exception e) {
                        System.out.println("the account number you entered is not found");
                    }

                case 6:
                    //Transfer
                    int from = getSourceAccountNum();
                    int to = getDestinationAccountNum();
                    double amnt = getAmountToTransferInput();
                    try {
                        customerService.transfer(from, to, amnt);
                        System.out.println();

                    } catch (Exception e) {
                        e.getMessage();
                        System.out.println("the account numbers are not found");
                    }
                    break;
                case 7:
                    //login
                    String USERNAME =getUsernameForLoginInput();
                    String PASSWORD =getPasswordForLoginInput();
                    try{
                        customerService.loginAccount(USERNAME,PASSWORD);
                        System.out.println();
                    } catch (Exception e) {
                        e.getMessage();
                        System.out.println("the account numbers are not found");
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid entry,please try again");

            }
        }   while(choice !=8);
        System.out.println("Thank-you for using our service");
}
// ----LoginAccount
    private String getPasswordForLoginInput() {
        System.out.println("Enter your password to login to account");
        String input =sc.nextLine();
        return input;
    }

    private String getUsernameForLoginInput() {
        System.out.println("Enter username to login to your account");
        String input =sc.nextLine();
        return input;
    }

    //Transfer fund
    private double getAmountToTransferInput() {
        System.out.println("Enter the amount you want to transfer");
        double input =sc.nextDouble();
        return input;
    }

    private int getDestinationAccountNum() {
        System.out.println("Enter your destination account number ");
        int input =sc.nextInt();
        return input;
    }

    private int getSourceAccountNum() {
        System.out.println("Enter your source account number");
        int input =sc.nextInt();
        return input;
    }

    // -------------------getBalance
    private int gettingBalanceInput() {
        System.out.println("enter the account number you trying check balance");
        int input =sc.nextInt();
        return input;
    }

    // ----------------------deposit
    private double gettingAmountInput() {
        System.out.println("enter the amount you like to deposit");
        double input =sc.nextDouble();
        return input;
    }

    private int gettingAccountToDeposit() {
        System.out.println("enter the account you are deposit at");
        int input =sc.nextInt();
        return input;
    }

    //------------- withdraw()
    private double getAmountInput() {
        System.out.println("enter the amount you would like to withdraw");
        double input =sc.nextDouble();
        return input;
    }

    private int gettingAccNumWithdrawFrom() {
        System.out.println("enter the account number that you're withdrawing from");
        int input =sc.nextInt();
        return input;
    }

// ----------------getCustomerByUsername()
    private String gettingUsernameInput() {
        System.out.println("Enter a username of the customer that you would to look up");
        String input =Menu.sc.nextLine().trim();
        return input;
    }
// ---------------CreateAccount()
    private double getBalanceInput() {
        System.out.println("Enter the initial balance");
        double balance =sc.nextDouble();
        return balance;
    }

    private int getAccountNumInput() {
        System.out.println("enter the account number for the new account");
        int account_num =sc.nextInt();
      return account_num;
    }

    private String getPasswordInput() {
        System.out.println("Set a password for the new account");
        String password =sc.nextLine();
        return password;
    }

    private String getUsernameInput() {
        System.out.println("Set a user name for the new account");
        String useranme =sc.nextLine();
        return  useranme;
    }

    private String getLastnameInput() {
        System.out.println("Enter last name for the account created");
        String lastname =sc.nextLine();
        return lastname;
    }

    private String getFirstnameInput() {
        System.out.println("Enter first name for the account created");
        String firstname =sc.nextLine();
        return firstname;
        }
        //
}








