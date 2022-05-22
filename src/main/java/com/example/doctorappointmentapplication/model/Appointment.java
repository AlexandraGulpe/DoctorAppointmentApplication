package com.example.doctorappointmentapplication.model;

import org.dizitart.no2.objects.Id;

public class Appointment {
    @Id
    private int id;
    private String patientUsername;
    private String doctorUsername;
    private String doctorName;
    private String day;
    private String month;
    private String year;
    private String hour;
    private String appointmentStatus; //


    public Appointment(int id,String patientUsername,String doctorUsername,String doctorName,String day,String month,String year,String hour){
        this.id=id;
        this.patientUsername=patientUsername;
        this.doctorUsername=doctorUsername;
        this.doctorName=doctorName;
        this.day=day;
        this.month=month;
        this.year=year;
        this.hour=hour;
        this.appointmentStatus="Pending";

    }
    public Appointment(){}
    public  int getId(){return id ;}
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
    public void setAppointmentStatus(String s){
        this.appointmentStatus=s;
    }

}
