package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class LogEntry
{
            private LocalDate date;
            private LocalTime time;
            private String event;
            private String message;

    public LogEntry(LocalDate date, LocalTime time, String event, String message)
    {
        this.date = date;
        this.time = time;
        this.event = event;
        this.message = message;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public String getEvent()
    {
        return event;
    }

    public String getMessage()
    {
        return message;
    }

}
