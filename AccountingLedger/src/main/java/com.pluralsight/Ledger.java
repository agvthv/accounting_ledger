package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Ledger
{
    private static Scanner userInput = new Scanner(System.in);

    public void runLedgerMenu() {
        System.out.println();
        System.out.println("Ledger");
        System.out.println("-".repeat(20));
        System.out.println("Choose an option:");
        System.out.println();
        System.out.println(" A) Display all entries \n D) Display deposit entries \n P) Display payment entries \n R) Reports \n H) Home Page ");
        System.out.println();
        System.out.print("Enter choice here: ");
        String choice = userInput.nextLine();

        switch (choice.toUpperCase()) {
            case "A":
                displayAllEntries();
                break;
            case "D":
                displayDeposit();
                break;
            case "P":
                displayPayment();
                break;
            case "R":
                Reports report = new Reports();
                report.runReportMenu();
                break;
            case "H":
                new homeSelection();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        runLedgerMenu();
    }
    public void displayAllEntries() {
        String path = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            System.out.println();
            System.out.println("    DATE   |   TIME   |  DESCRIPTION  |  VENDOR  |  COST ");
            System.out.println("---------------------------------------------------");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String date = parts[0].trim();
                    String time = parts[1].trim();
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    String cost = parts[4].trim();
                    System.out.format("%-10s | %-8s | %-13s | %-8s | $%.2f%n", date, time, description, vendor, Double.parseDouble(cost));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        runLedgerMenu();
    }
    public void displayDeposit(){
        String path = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            System.out.println();
            System.out.println("    DATE   |   TIME   |  DESCRIPTION  |  VENDOR  |  COST ");
            System.out.println("---------------------------------------------------");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String date = parts[0].trim();
                    String time = parts[1].trim();
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    String cost = parts[4].trim();
                    double costValue = Double.parseDouble(cost);

                    if (costValue >= 0){
                        System.out.format("%-10s | %-8s | %-13s | %-8s | $%.2f%n", date, time, description, vendor, Double.parseDouble(cost));

                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        runLedgerMenu();
    }
    public void displayPayment(){
        String path = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            System.out.println();
            System.out.println("    DATE   |   TIME   |  DESCRIPTION  |  VENDOR  |  COST ");
            System.out.println("---------------------------------------------------");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String date = parts[0].trim();
                    String time = parts[1].trim();
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    String cost = parts[4].trim();
                    double costValue = Double.parseDouble(cost);

                    if (costValue <= 0){
                        System.out.format("%-10s | %-8s | %-13s | %-8s | $%.2f%n", date, time, description, vendor, Double.parseDouble(cost));

                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        runLedgerMenu();
    }

}

