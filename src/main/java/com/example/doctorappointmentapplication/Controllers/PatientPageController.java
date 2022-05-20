package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.HelloApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
public class PatientPageController {

    @FXML
    private Button LogOutButton;



    public void logOutButtonOnAction(ActionEvent event) throws Exception{
        URL adrr = HelloApplication.class.getResource("hello-view.fxml");


        Parent root = FXMLLoader.load(adrr);
        Stage window = (Stage) LogOutButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));
    }
}

