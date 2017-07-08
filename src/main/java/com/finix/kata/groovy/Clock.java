package com.finix.kata.groovy;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by alex on 7/8/17.
 */
public class Clock {

    public static final String DATETIME_FORMAT = "dd/MM/yyyy";
    protected LocalDate now = LocalDate.now();

    public String nowToString() {
        return now.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
