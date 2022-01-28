package com.revature.ui;

public class BankAdminMenu implements Menu {

    @Override
    public void display() {
        int choice = 0;
        do {
            System.out.println("=======BANKADMIN MENU====");
            System.out.println("1.) Approve Account Application");
            System.out.println("2.) Deny Account Application");
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
                    //Approve an account
                    break;
                case 2:
                    //deny an account
                    break;
                case 3:
                    //cancel an account
                    break;
                case 4:
                    //withdraw from an account
                case 5:
                    // Deposit to an account
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
}
