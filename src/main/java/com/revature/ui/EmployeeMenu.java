package com.revature.ui;

public class EmployeeMenu implements Menu {
    public EmployeeMenu() {
    }

    @Override
    public void display() {
        int choice = 0;
        do {
            System.out.println("====EMPLOYEE MENU=====");
            System.out.println("1.) Approve Application for Account");
            System.out.println("2.) Deny Application for Account");
            System.out.println("3.) Back");
            try {
                choice = Integer.parseInt(Menu.sc.nextLine());
            } catch (NumberFormatException e) {
                e.fillInStackTrace();
            }

            switch (choice) {
                case 1:
                    // needed to filled up from the based EmployeeService class
                    break;
                case 2:
                    // need to filled up based on EmployeeService class
                case 3:
                    break;
                default:
                    System.out.println("No valid choice entered,please try again");
            }

        }while (choice != 3) ;

    }
}

