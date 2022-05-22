package com.example.doctorappointmentapplication.exceptions;

public class InvalidDayException extends Exception{
    public InvalidDayException(){
        super("Please enter a valid day of the month");
    }

}
