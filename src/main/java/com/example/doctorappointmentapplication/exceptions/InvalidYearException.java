package com.example.doctorappointmentapplication.exceptions;

public class InvalidYearException extends Exception{
    public InvalidYearException(){
        super("Please enter current year or next");

    }

}
