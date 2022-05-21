package com.example.doctorappointmentapplication.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import  com.example.doctorappointmentapplication.model.Appointment;

public class AppointmentService {
    private static ObjectRepository<Appointment> AppointmentsRepository;
    public static void initDatabase(){
        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("DoctorAppointments.db").toFile())
                .openOrCreate("DoctorAppointments", "DoctorAppointments");
        AppointmentsRepository= database.getRepository(Appointment.class);
    }
    public static void scheduleAppointment(Appointment a){
        AppointmentsRepository.insert(a);
    }

}
