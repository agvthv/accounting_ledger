package com.pluralsight;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homeSelection {
    private static Scanner userInput = new Scanner(System.in);

    public homeSelection() {
        System.out.println("Welcome to Jung Bank");
        System.out.println("Choose an option:");
        System.out.println(" D) Add Deposit \n P) Make Payment \n L) Ledger \n X) Exit \n");
        System.out.print("Enter choice here: ");
        String choice = userInput.nextLine();

        if(choice.equalsIgnoreCase("D")) {
            deposit(Logger.getLogger(homeSelection.class.getName()), userInput);
        } else if(choice.equalsIgnoreCase("P")) {
            payment();
        } else if(choice.equalsIgnoreCase("L")) {
            ledger();
        } else if(choice.equalsIgnoreCase("X")) {
            System.out.println();
            System.out.println("-".repeat(30));
            System.out.println("Thank you for logging in");
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void deposit(Logger logger, Scanner userInput) {
        System.out.print("Enter deposit amount: ");
        double depositAmount = Double.parseDouble(userInput.nextLine());
        System.out.printf("You have successfully deposited $%.2f to your bank.", depositAmount);
        logger.log(Level.INFO, "Amount: $" + depositAmount);

        saveToCSV(depositAmount);

    }

    private static void saveToCSV(double depositAmount) {
        String csvFile = "deposit.csv";
        try (FileWriter writer = new FileWriter(csvFile, true)) {

            writer.append(depositAmount + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void payment() {
        System.out.println("Enter deposit amount: ");
        double paymentAmount = Double.parseDouble(userInput.nextLine());
        System.out.println("");
    }

    public static void ledger() {
        System.out.println("Enter deposit amount");
        double ledger = Double.parseDouble(userInput.nextLine());
        System.out.println("");
    }
}
