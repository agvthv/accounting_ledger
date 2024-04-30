package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class logger
{

    private final String LOG_DIRECTORY_PATH = "logs";
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_DATE;
    private final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("kk:mm:ss");

    private String fileName;
    private String filePath;

    public logger(String fileName)
    {
        File directory = new File(LOG_DIRECTORY_PATH);
        if(!directory.exists())
        {
            directory.mkdir();
        }

        // checks to see if the folder exists - creates it if it doesn't
        this.fileName = fileName;
        this.filePath = LOG_DIRECTORY_PATH + "/" + fileName;
        if(!this.filePath.toLowerCase().endsWith(".csv"))
        {
            this.filePath += ".csv";
        }
    }

    public void logMessage(String event, String message)
    {

        File logFile = new File(filePath);
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        try(FileWriter fileWriter = new FileWriter(logFile, true);
            PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            writer.printf("%s | %s | %s | %s\n", date.format(DATE_FORMAT), time.format(TIME_FORMAT), event, message);
        }
        catch (IOException ex)
        {

        }


    }

    public ArrayList<LogEntry> readLog()
    {
        ArrayList<LogEntry> logEntries = new ArrayList<>();

        File logFile = new File(filePath);

        try(FileReader fileReader = new FileReader(logFile);
            Scanner scanner = new Scanner(fileReader);
        )
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\\s\\|\\s");

                LocalDate date = LocalDate.parse(lineScanner.next(), DATE_FORMAT);
                LocalTime time = LocalTime.parse(lineScanner.next(), TIME_FORMAT);
                String event = lineScanner.next();
                String message = lineScanner.next();

                LogEntry logEntry = new LogEntry(date, time, event, message);

                logEntries.add(logEntry);
            }

        }
        catch (IOException ex)
        {

        }

        return logEntries;
    }
}

