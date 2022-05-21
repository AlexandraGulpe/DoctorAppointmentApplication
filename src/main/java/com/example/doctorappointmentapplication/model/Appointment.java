package com.example.doctorappointmentapplication.model;

public class Appointment {
    private String patientUsername;
    private String doctorName;
    private String day;
    private String month;
    private String year;
    private String hour;

    public Appointment(String patientUsername,String doctorName,String day,String month,String year,String hour){

        this.patientUsername=patientUsername;
        this.doctorName=doctorName;
        this.day=day;
        this.month=month;
        this.year=year;
        this.hour=hour;


    }

}
