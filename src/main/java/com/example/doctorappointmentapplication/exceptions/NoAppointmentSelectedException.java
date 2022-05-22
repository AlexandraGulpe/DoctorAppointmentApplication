package com.example.doctorappointmentapplication.exceptions;

public class NoAppointmentSelectedException extends Exception{
    public NoAppointmentSelectedException(){

        super("Please select an appointment");
    }
}
