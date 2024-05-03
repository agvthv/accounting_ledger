package com.pluralsight;

import java.util.Scanner;

public class Reports
{
    private static Scanner userInput = new Scanner(System.in);

    public void runReportMenu(){
        System.out.println();
        System.out.println("Reports");
        System.out.println("-".repeat(20));
        System.out.println("Choose an option:");
        System.out.println();
        System.out.println(" 1) Month To Date \n 2) Previous Month \n 3) Year To Date \n 4) Previous Year \n 5) Search By Vendor \n 0) Back ");
        System.out.println();
        System.out.print("Enter choice here: ");
        String choice = userInput.nextLine();

        switch (choice.toUpperCase()) {
            case "1":
                //displayAllEntries();
                break;
            case "2":
                //displayDeposit();
                break;
            case "3":
                //displayPayment();
                break;
            case "4":
                Reports report = new Reports();
                report.runReportMenu();
                break;
            case "5":
                System.out.println();
                System.out.println("-".repeat(30));
                System.out.println("Thank you for logging in");
                break;
            case "0":
                System.out.println();
                System.out.println("-".repeat(30));
                System.out.println("Thank you for logging in");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
