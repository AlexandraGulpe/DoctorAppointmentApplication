package com.example.doctorappointmentapplication.model;

public class Appointment {
    private String patientUsername;
    private String doctorName;
    private String day;
    private String month;
    private String hour;
    private String appointmentStatus; //


    public Appointment(String patientUsername,String doctorName,String day,String month,String year,String hour,String appointmentStatus){

        this.patientUsername=patientUsername;
        this.doctorName=doctorName;
        this.day=day;
        this.month=month;
        this.hour=hour;
        this.appointmentStatus=appointmentStatus;

    }
    public String getDay(){
        return day;
    }
    public String getMonth(){
        return month;
    }
    public String getHour(){
        return hour;
    }
    public String getAppointmentStatus(){
        return appointmentStatus;
    }

}
