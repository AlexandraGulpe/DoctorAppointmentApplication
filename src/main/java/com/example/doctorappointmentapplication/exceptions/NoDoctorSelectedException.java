package com.example.doctorappointmentapplication.exceptions;

public class NoDoctorSelectedException extends Exception {
    public NoDoctorSelectedException(){
        super("Please select a doctor!");
    }
}
