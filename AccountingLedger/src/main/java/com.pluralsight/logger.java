package com.pluralsight;

import java.io.*;
import java.time.format.DateTimeFormatter;


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
        if (!directory.exists()) {
            directory.mkdir();
        }

        // checks to see if the folder exists - creates it if it doesn't
        this.fileName = fileName;
        this.filePath = LOG_DIRECTORY_PATH + "/" + fileName;
        if (!this.filePath.toLowerCase().endsWith(".csv")) {
            this.filePath += ".csv";
        }
    }

}

