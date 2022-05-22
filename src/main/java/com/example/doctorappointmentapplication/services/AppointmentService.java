package com.example.doctorappointmentapplication.services;
import com.example.doctorappointmentapplication.model.User;
import com.example.doctorappointmentapplication.services.UserService;

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
    public static void scheduleAppointment(int id,String patientUsername,String doctorUsername,String doctorName,String day,String month,String year,String hour){
        AppointmentRepository.insert(new Appointment(id,patientUsername,doctorUsername,doctorName,day,month,year,hour));
    }


    public static List<String> getPatientAppointmentList(String username){

        List <String> appointmentList =new ArrayList<>();

        for(Appointment appointment:AppointmentRepository.find()){
            if(Objects.equals(appointment.getPatientUsername(),username)){

                appointmentList.add("Doctor: " + appointment.getDoctorName()+ " \nOn date:" + appointment.getDay() +" \\"+
                        appointment.getMonth() + " \\" + appointment.getYear() + "\nAt:" + appointment.getHour() + "\nStatus: " + appointment.getAppointmentStatus());

            }


        }
        return appointmentList;



    }

    public static List<String> getDoctorPendingAppointmentList(String username){

        List <String> appointmentList =new ArrayList<>();

        for(Appointment appointment:AppointmentRepository.find()){
            if(Objects.equals(appointment.getDoctorName(),username) && Objects.equals(appointment.getAppointmentStatus(),"Pending")){

                appointmentList.add("AppointmentID: " + appointment.getId() + "\n Doctor: " + appointment.getDoctorName()+ "\n On date: " + appointment.getDay() +" \\"+
                        appointment.getMonth() + " \\" + appointment.getYear() + "\n At: " + appointment.getHour()  );

            }


        }
        return appointmentList;



    }

    public static int findID(String u) {
        for(Appointment appointment: AppointmentRepository.find() ){
            if(Objects.equals(u,appointment.getId()))
                return appointment.getId();

            }
        return -1;
        }

    public static void setAppointmentStatus(int id,String status){
        for(Appointment appointment : AppointmentRepository.find()){
            if(Objects.equals(id,appointment.getId())){
                appointment.setAppointmentStatus(status);
                AppointmentRepository.update(appointment);
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
