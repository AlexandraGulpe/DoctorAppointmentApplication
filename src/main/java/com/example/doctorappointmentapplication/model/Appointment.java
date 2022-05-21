package com.example.doctorappointmentapplication.model;

public class Appointment {
    private String patientUsername;
    private String doctorName;
    private String day;
    private String month;
    private String year;
    private String hour;
    private String appointmentStatus; //


    public Appointment(String patientUsername,String doctorName,String day,String month,String year,String hour){

        this.patientUsername=patientUsername;
        this.doctorName=doctorName;
        this.day=day;
        this.month=month;
        this.hour=hour;
        this.appointmentStatus="Pending";

    }
    public Appointment(){}
    public String getPatientUsername(){
        return patientUsername;
    }
    public String getDoctorName(){
        return doctorName;
    }

    public String getDay(){
        return day;
    }
    public String getMonth(){
        return month;
    }
    public String getYear(){
        return year;
    }
    public String getHour(){
        return hour;
    }
    public String getAppointmentStatus(){
        return appointmentStatus;
    }

}
