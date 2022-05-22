package com.example.doctorappointmentapplication.exceptions;

public class InvalidHourException extends Exception {
    public InvalidHourException() {
        super("Please enter a valid calendar date");
    }
}

