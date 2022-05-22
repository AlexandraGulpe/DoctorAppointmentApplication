package com.example.doctorappointmentapplication.exceptions;

public class InvalidHourException extends Exception {
    public InvalidHourException() {
        super("Please enter a hour between 10 and 16!");
    }
}

