package com.example.doctorappointmentapplication.services;

import com.example.doctorappointmentapplication.exceptions.*;
import javafx.scene.control.TextField;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import  com.example.doctorappointmentapplication.model.Appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppointmentService {
    public static ObjectRepository<Appointment> AppointmentRepository;

    public static void initDatabase(){
        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("DoctorAppointments.db").toFile())
                .openOrCreate("DoctorAppointments", "DoctorAppointments");
        AppointmentRepository = database.getRepository(Appointment.class);
    }
    public static int getLastId(){
        int id=0;
        for(Appointment appointment : AppointmentRepository.find()){
            id= Math.max(id, appointment.getId());
        }
        return id;
    }
    public static void scheduleAppointment(int id,String patientUsername,String doctorUsername,String doctorName,String day,String month,String year,String hour) throws InvalidMonthException,InvalidDayException,InvalidYearException, InvalidHourException,HourIsAlreadyOccuppiedException {

        invalidDayException(day,month);
        invalidMonthException(month);
        invalidYearException(year);
        invalidHourException(hour);
        occupiedHour(day,month,year,hour,doctorUsername);

        AppointmentRepository.insert(new Appointment(id,patientUsername,doctorUsername,doctorName,day,month,year,hour));
    }


    public static List<String> getPatientAppointmentList(String username){

        List <String> appointmentList =new ArrayList<>();

        for(Appointment appointment:AppointmentRepository.find()){
            if(Objects.equals(appointment.getPatientUsername(),username)){

                appointmentList.add("\nDoctor: " + appointment.getDoctorName()+ " \nOn date:" + appointment.getDay() +" \\"+
                        appointment.getMonth() + " \\" + appointment.getYear() + "\nAt:" + appointment.getHour() +
                        "\nStatus: " + appointment.getAppointmentStatus() + "\n" + appointment.getMessage());

            }
        }
        return appointmentList;

    }

    public static List<String> getDoctorPendingAppointmentList(String username){

        List <String> appointmentList =new ArrayList<>();

        for(Appointment appointment:AppointmentRepository.find()){
            if(Objects.equals(appointment.getDoctorName(),username) && Objects.equals(appointment.getAppointmentStatus(),"Pending")){

                appointmentList.add("\nAppointmentID: " + appointment.getId() + "\n User: " + appointment.getPatientUsername()+ "\n On date: " + appointment.getDay() +" \\"+
                        appointment.getMonth() + " \\" + appointment.getYear() + "\n At: " + appointment.getHour());

            }
        }
        return appointmentList;



    }

    public static int findID(String u) {
        for(Appointment appointment: AppointmentRepository.find() ){
            if(Objects.equals(u,("\nAppointmentID: " + appointment.getId() + "\n User: " + appointment.getPatientUsername()+ "\n On date: " + appointment.getDay() +" \\"+
                    appointment.getMonth() + " \\" + appointment.getYear() + "\n At: " + appointment.getHour()))) {

                return appointment.getId();
            }

        }
        return -1;
    }


    public static void setAppointmentStatus(int id, String status, String message){
        for(Appointment appointment : AppointmentRepository.find()){
            if(Objects.equals(id,appointment.getId())){
                appointment.setAppointmentStatus(status);
                appointment.setMessage(message);
                AppointmentRepository.update(appointment);
            }
        }
    }

    public static void invalidDayException(String d,String m) throws InvalidDayException{
        if( (Integer.parseInt(m,10)==1) || (Integer.parseInt(m,10)==3) || (Integer.parseInt(m,10)==5) || (Integer.parseInt(m,10)==7) ||
                (Integer.parseInt(m,10)==8) || (Integer.parseInt(m,10)==10) || (Integer.parseInt(m,10)==12) ){

            if(Integer.parseInt(d,10)>31 || Integer.parseInt(d,10)<1)
                throw new InvalidDayException();
        }
        if( (Integer.parseInt(m,10)==4) || (Integer.parseInt(m,10)==6) || (Integer.parseInt(m,10)==9) || (Integer.parseInt(m,10)==11)){
            if(Integer.parseInt(d,10)>30 || Integer.parseInt(d,10)<1)
                throw new InvalidDayException();

        }
        if(Integer.parseInt(m,10)==2){
            if(Integer.parseInt(d,10)>28 || Integer.parseInt(d,10)<1)
                throw new InvalidDayException();
        }
    }

    public static void invalidMonthException(String a) throws InvalidMonthException{
        if(Integer.parseInt(a,10)<1 || Integer.parseInt(a,10) >12){
            throw new InvalidMonthException();
        }
    }

    public static void invalidYearException(String a) throws InvalidYearException{
        if(Integer.parseInt(a,10)!=2022 && Integer.parseInt(a,10)!=2023){
            throw new InvalidYearException();

        }
    }

    public static void invalidHourException(String a) throws InvalidHourException{
        if((Integer.parseInt(a,10)<10) || (Integer.parseInt(a,10)>16)){
            throw new InvalidHourException();
        }
    }

    public static void occupiedHour(String d,String m,String y,String h,String dName) throws HourIsAlreadyOccuppiedException {

        for (Appointment appointment : AppointmentRepository.find()) {
            if (Objects.equals(d, appointment.getDay()) && Objects.equals(m, appointment.getMonth()) && Objects.equals(y, appointment.getYear()) && Objects.equals(h, appointment.getHour())
                    && Objects.equals(dName, appointment.getDoctorName())) {
                throw new HourIsAlreadyOccuppiedException();
            }

        }

    }



   /* public static List<String> getDoctorApprovedAppointmentList(String name){

        List <String> appointmentList =new ArrayList<>();

        for(Appointment appointment:AppointmentRepository.find()){
            if(Objects.equals("AppointmentID:" + appointment.getId() + appointment.getDoctorName(),name) && Objects.equals(appointment.getAppointmentStatus(),"Approved")){

                appointmentList.add("Doctor: " + appointment.getDoctorName()+ " On date:" + appointment.getDay() +" \\"+
                        appointment.getMonth() + " \\" + appointment.getYear() + "At:" + appointment.getHour()  );

            }


        }
        return appointmentList;



    }*/







}
