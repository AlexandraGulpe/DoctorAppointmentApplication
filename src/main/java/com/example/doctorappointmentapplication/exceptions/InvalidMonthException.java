package com.example.doctorappointmentapplication.exceptions;

public class InvalidMonthException extends Exception {
    public InvalidMonthException(){
        super("Please enter a valid month");

    }
}
