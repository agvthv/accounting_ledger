package com.pluralsight;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homeSelection {
    private static Scanner userInput = new Scanner(System.in);

    public homeSelection() {
        System.out.println("☆".repeat(20));
        System.out.println("Welcome to Jung Bank");
        System.out.println("☆".repeat(20));
        System.out.println("Choose an option:");
        System.out.println();
        System.out.println(" D) Add Deposit \n P) Make Payment \n L) Ledger \n X) Exit \n");
        System.out.print("Enter choice here: ");
        String choice = userInput.nextLine();

        switch (choice.toUpperCase()) {
            case "D":
                deposit(Logger.getLogger(homeSelection.class.getName()), userInput);
                break;
            case "P":
                payment();
                break;
            case "L":
                ledger();
                break;
            case "X":
                System.out.println();
                System.out.println("-".repeat(30));
                System.out.println("Thank you for logging in");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void deposit(Logger logger, Scanner userInput) {
        System.out.print("Enter deposit purpose: ");
        String depositPurpose = userInput.nextLine().toUpperCase();
        System.out.print("Enter vendor: ");
        String depositVendor = userInput.nextLine().toUpperCase();
        System.out.print("Enter deposit amount: ");
        double depositAmount = Double.parseDouble(userInput.nextLine());
        System.out.printf("You have successfully deposited $%.2f to your account.", depositAmount);
        String depositInfo = depositPurpose + "|" + depositVendor + "|" + depositAmount;
        saveToCSV(depositInfo);



    }
    public static void payment() {
        System.out.print("Enter payment purpose: ");
        String paymentPurpose = userInput.nextLine().toUpperCase();
        System.out.print("Enter vendor: ");
        String paymentVendor = userInput.nextLine().toUpperCase();
        System.out.print("Enter payment amount: ");
        double paymentAmount = Double.parseDouble(userInput.nextLine());
        System.out.printf("You have successfully paid -$%.2f from your account.", paymentAmount);
        String paymentInfo = paymentPurpose + "|" + paymentVendor + "|" + paymentAmount;
        saveToCSV(paymentInfo);
    }


    public static void ledger() {
        System.out.println(" D) Display all entries \n P) Make Payment \n L) Ledger \n X) Exit \n");
        System.out.print("Enter choice here: ");
        String choice = userInput.nextLine();

        switch (choice.toUpperCase()) {
            case "D":
                deposit(Logger.getLogger(homeSelection.class.getName()), userInput);
                break;
            case "P":
                payment();
                break;
            case "L":
                ledger();
                break;
            case "X":
                System.out.println();
                System.out.println("-".repeat(30));
                System.out.println("Thank you for logging in");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private static void saveToCSV(String transactionInfo) {
        String csvFile = "AccountingLedger/file/transactions.csv";
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        try (FileWriter writer = new FileWriter(csvFile, true)) {

            writer.append(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "|");
            writer.append(time.format(DateTimeFormatter.ofPattern("hh:mm:ss"))+ "|");
            writer.append(transactionInfo + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
