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
    public static void scheduleAppointment(String patientUsername,String doctorName,String day,String month,String year,String hour){
        AppointmentRepository.insert(new Appointment(patientUsername,doctorName,day,month,year,hour));
    }


    public static List<String> getPatientAppointmentList(String username){

        List <String> appointmentList =new ArrayList<>();

        for(Appointment appointment:AppointmentRepository.find()){
            if(Objects.equals(appointment.getPatientUsername(),username)){

                appointmentList.add("Doctor: " + appointment.getDoctorName()+ " On date:" + appointment.getDay() +" \\"+
                        appointment.getMonth() + " \\" + appointment.getYear() + "At:" + appointment.getHour() + "Status: " + appointment.getAppointmentStatus());

            }


        }
        return appointmentList;



    }




}
