package com.example.doctorappointmentapplication.exceptions;

public class HourIsAlreadyOccuppiedException extends Exception {
    public HourIsAlreadyOccuppiedException(){
        super("Hour Occupied ! Please change hour");

    }
}
