package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class csvReader
{

    public void saveToCSV(String transactionInfo) {
        String csvFile = "/Users/agathasilva/Desktop/PluralSight/LearnToCode_Capstones/accounting_ledger/AccountingLedger/file/transactions.csv";
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        try (FileWriter writer = new FileWriter(csvFile, true)) {

            writer.append(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " | ");
            writer.append(time.format(DateTimeFormatter.ofPattern("hh:mm:ss"))+ " | ");
            writer.append(transactionInfo + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
