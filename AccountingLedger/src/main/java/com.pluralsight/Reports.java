package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports
{
    private static Scanner userInput = new Scanner(System.in);

    public static void runReportMenu() throws FileNotFoundException
    {
        System.out.println();
        System.out.println("Reports");
        System.out.println("-".repeat(20));
        System.out.println("Choose an option:");
        System.out.println(" 1) Month To Date \n 2) Previous Month \n 3) Year To Date \n 4) Previous Year \n 5) Search By Vendor \n 0) Back ");
        System.out.print("Enter choice here: ");
        String choice = userInput.nextLine();

        switch (choice) {
            case "1":
                monthToDate();
                break;
            case "2":
                previousMonth();
                break;
            case "3":
                yearToDate();
                break;
            case "4":
                previousYear();
                break;
            case "5":
                searchVendor();
                break;
            case "0":
                // Assuming Ledger is another class with its menu
                Ledger ledger = new Ledger();
                ledger.runLedgerMenu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    public static void monthToDate() throws FileNotFoundException
    {
        String filePath = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        LocalDate today = LocalDate.now();
        LocalDate month2Date = today.withDayOfMonth(1);
        int todayMonth = today.getMonthValue();
        int todayYear = today.getYear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                try {
                    LocalDate date = LocalDate.parse(parts[0]);
                    if (date.getMonthValue() == todayMonth && date.getYear() == todayYear) {
                        System.out.println(line);
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Failed to parse date from line: '" + line + "'");
                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }
        runReportMenu();
    }

    public static void previousMonth() throws FileNotFoundException
    {
        String filePath = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusMonths(1).withDayOfMonth(1);
        LocalDate lastDay = today.withDayOfMonth(1).minusDays(1);  // Last day of the previous month

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                try {
                    LocalDate date = LocalDate.parse(parts[0]);
                    if (!date.isBefore(firstDay) && !date.isAfter(lastDay)) {
                        System.out.println(line);
                    }
                } catch (DateTimeParseException e) {

                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }
        runReportMenu();
    }

    public static void yearToDate() throws FileNotFoundException
    {
        String filePath = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        LocalDate today = LocalDate.now();
        LocalDate startOfTheYear = LocalDate.of(today.getYear(), 1, 1);  // First day of the current year

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                try {
                    LocalDate date = LocalDate.parse(parts[0]);
                    if (!date.isBefore(startOfTheYear) && !date.isAfter(today)) {  // Check if the date is within the current year to date
                        System.out.println(line);
                    }
                } catch (DateTimeParseException e) {

                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }
        runReportMenu();
    }

    public static void previousYear() throws FileNotFoundException
    {
        String filePath = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        LocalDate today = LocalDate.now();
        LocalDate startOfLastYear = LocalDate.of(today.getYear() - 1, 1, 1);  // First day of the previous year
        LocalDate endOfLastYear = LocalDate.of(today.getYear() - 1, 12, 31);  // Last day of the previous year

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                try {
                    LocalDate date = LocalDate.parse(parts[0]);
                    if (!date.isBefore(startOfLastYear) && !date.isAfter(endOfLastYear)) {  // Check if the date is within the previous year
                        System.out.println(line);
                    }
                } catch (DateTimeParseException e) {

                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }
        runReportMenu();
    }

    public static void searchVendor() throws FileNotFoundException {
        System.out.print("Enter the vendor name to search for: ");
        String searchVendor = userInput.nextLine().toUpperCase();  // Convert input to uppercase for case-insensitive comparison
        String filePath = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                String vendor = parts[3].toUpperCase();

                if (vendor.contains(searchVendor)) {
                    System.out.println(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No transactions found for the vendor: " + searchVendor);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        runReportMenu();
    }


}