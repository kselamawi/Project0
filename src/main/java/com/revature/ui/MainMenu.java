package com.revature.ui;


public class MainMenu  implements Menu {

    @Override
    public void display() {
        System.out.println("Welcome to the application");
        int choice = 0;
        do {
            System.out.println("========MAIN MENU====");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|        Welcome to Mr.S's                             |");
            System.out.println("|        Excellent Bank App                            |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("Please select an option below");
            System.out.println("1.) CustomerMenu");
            System.out.println("2.) EmployeeMenu");
            System.out.println("3.) BankAdminMenu");
            System.out.println("4.) Exit Application");
            try {
                choice = Integer.parseInt(Menu.sc.nextLine());
            } catch (NumberFormatException e) {
                e.fillInStackTrace();
            }

            switch (choice) {
                case 1:
                    Menu customerMenu = new CustomerMenu();
                    customerMenu.display();
                    break;
                case 2:
                    Menu employeMenu = new EmployeeMenu();
                    employeMenu.display();
                    break;
                case 3:
                    Menu bankAdminMenu = new BankAdminMenu();
                    bankAdminMenu.display();
                case 4:
                    break;
                default:
                    System.out.println("No valid choice entered,please try again");
            }
        } while (choice != 4);


    }
}

