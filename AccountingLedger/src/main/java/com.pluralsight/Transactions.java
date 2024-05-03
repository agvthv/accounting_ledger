package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transactions
{
            private LocalDate date;
            private LocalTime time;
            private String description;
            private String vendor;
            private double cost;

    public Transactions(LocalDate date, String description, String vendor, double cost) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getCost() {
        return cost;
    }

    public String getTransaction() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "Date: " + dateFormatter + ", Time: " + timeFormatter + ", Description: " + description +
                ", Vendor: " + vendor + ", Cost: $" + String.format("%.2f", cost);
    }
}
