package com.revature.ui;

public class CustomerMenu implements Menu {
    //public CustomerSerivce customerSerivce;
    //public CustomerMenu() {
    //this.customerSerivce =new CustomerService();
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
            System.out.println("2.) Login to an account");
            System.out.println("3.) Deposit to an account ");
            System.out.println("4.) Withdraw from an account");
            System.out.println("5.)Transfer to another account");
            System.out.println("6.) Back");
            try {
                choice = Integer.parseInt(Menu.sc.nextLine());
            } catch (NumberFormatException e) {
                e.fillInStackTrace();
            }
            switch (choice) {
                case 1:
                    // create an account
                    break;
                case 2:
                    //Login to an account
                    break;
                case 3:
                    //deposit
                    break;
                case 4:
                    //withdraw
                    break;
                case 5:
                    //Transfer
                case 6:
                    break;
                default:
                    System.out.println("Invalid entry,please try again");
            }
        }
        while (choice != 6);


    }
}


