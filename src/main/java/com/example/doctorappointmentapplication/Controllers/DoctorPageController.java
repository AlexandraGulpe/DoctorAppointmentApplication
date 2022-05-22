package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.model.DoctorProfile;
import com.example.doctorappointmentapplication.services.AppointmentService;
import com.example.doctorappointmentapplication.services.DoctorFacilitiesService;
import com.example.doctorappointmentapplication.HelloApplication;

import com.example.doctorappointmentapplication.services.ProfileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
public class DoctorPageController {
    
    @FXML
    private Button LogOutButton;

    @FXML
    private Button myServicesButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private Button myAppointmentsButton;


    private String username;

    public void setUsername(String username){
        this.username = username;
    }

    public void myServicesButtonOnAction(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/doctorServices.fxml"));
        Parent root = loader.load();
        DoctorServicesPageController doctorServicesPageController = loader.getController();
        doctorServicesPageController.setUsername(username);
        doctorServicesPageController.setListView(DoctorFacilitiesService.getLista(username));


        Stage window = (Stage) myServicesButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));
    }

    public void myProfileButtonOnAction(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/doctorProfile.fxml"));
        Parent root = loader.load();
        DoctorProfilePageController doctorProfilePageController = loader.getController();
        doctorProfilePageController.setUsername(username);
        doctorProfilePageController.setListView(ProfileService.getLista(username));


        Stage window = (Stage) myProfileButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));


    }
    public void myAppointmentsButtonOnAction(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/doctorAppointments.fxml"));
        Parent root = loader.load();
        DoctorAppointmentsPageController doctorAppointmentsPageController = loader.getController();
        doctorAppointmentsPageController.setUsername(username);
        doctorAppointmentsPageController.setListView(AppointmentService.getDoctorPendingAppointmentList(username));

        Stage window =(Stage) myAppointmentsButton.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));



    }

    public void logOutButtonOnAction(ActionEvent event) throws Exception{
        URL adrr = HelloApplication.class.getResource("hello-view.fxml");


        Parent root = FXMLLoader.load(adrr);
        Stage window = (Stage) LogOutButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));
    }


}
