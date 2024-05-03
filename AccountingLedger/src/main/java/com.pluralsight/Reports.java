package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports
{
    private static Scanner userInput = new Scanner(System.in);

    public void runReportMenu() throws FileNotFoundException
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
                monthToDate("file/transactions.csv");
                break;
            case "2":
                //previousMonth();
                break;
            case "3":
                //yearToDate();
                break;
            case "4":
                //previousYear();
                break;
            case "5":
                //searchVendor();
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

    public static void monthToDate(String filePath) throws FileNotFoundException
    {
        ArrayList<Transactions> month2Date = new ArrayList<>();
        File file = new File(filePath);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().trim().split("\\|");
                LocalDate date = LocalDate.parse(data[1].trim(), dateFormatter);
                if (!date.isAfter(firstDayOfMonth)) {
                    String description = data[3].trim();
                    String vendor = data[5].trim();
                    double cost = Double.parseDouble(data[7].trim());
                    month2Date.add(new Transactions(date, description, vendor, cost));
                }
                }
            }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }

        month2Date.forEach(System.out::println);
    }
    }


//    public static void previousMonth() {}
//    public static void yearToDate() {}
//    public static void previousYear() {}
//    public static void searchVendor() {}

