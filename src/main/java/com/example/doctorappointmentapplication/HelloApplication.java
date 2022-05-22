package com.example.doctorappointmentapplication;

import com.example.doctorappointmentapplication.services.AppointmentService;
import com.example.doctorappointmentapplication.services.DoctorFacilitiesService;
import com.example.doctorappointmentapplication.services.ProfileService;
import com.example.doctorappointmentapplication.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
public class HelloApplication extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        UserService.initDatabase();
        DoctorFacilitiesService.initDatabase();
        ProfileService.initDatabase();
        AppointmentService.initDatabase();

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 1200, 800);


        primaryStage.setTitle("Doctor Appointment Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
