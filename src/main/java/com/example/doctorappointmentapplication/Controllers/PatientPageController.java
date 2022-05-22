package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.HelloApplication;

import com.example.doctorappointmentapplication.services.AppointmentService;
import com.example.doctorappointmentapplication.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
public class PatientPageController {

    @FXML
    private Button LogOutButton;

    @FXML
    private Button AppointmentHistoryButton;

    @FXML
    private Button DoctorsButton;

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void logOutButtonOnAction(ActionEvent event) throws Exception{
        URL adrr = HelloApplication.class.getResource("hello-view.fxml");


        Parent root = FXMLLoader.load(adrr);
        Stage window = (Stage) LogOutButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));
    }

    public void AppointmentHistoryButtonOnAction() throws Exception{
        Parent root;
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/appointmentHistory.fxml"));
            root = (Parent)loader.load();
            AppointmentHistoryController appointmentHistoryController = loader.getController();
            appointmentHistoryController.setUsername(username);
            appointmentHistoryController.setListView(AppointmentService.getPatientAppointmentList(username));
            Stage stage = new Stage();
            stage.setTitle("Appointment History");
            stage.setScene(new Scene(root, 1200, 800));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void doctorsButtonOnAction(ActionEvent event) throws Exception{

        Parent root;
        try {
            //root = FXMLLoader.load(adrr);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/doctorList.fxml"));
            root = (Parent)loader.load();
            DoctorListController doctorListController = loader.getController();
            doctorListController.setUsername(username);
            doctorListController.setListView(UserService.getDoctorList());
            Stage stage = new Stage();
            stage.setTitle("DoctorPage");
            stage.setScene(new Scene(root, 1200, 800));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }







}

