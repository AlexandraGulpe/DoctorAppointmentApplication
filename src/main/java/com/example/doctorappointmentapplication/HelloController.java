package com.example.doctorappointmentapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class HelloController {

    @FXML
    private Label labelField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button backButton;

    public void doctorButtonOnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage window = (Stage) loginButton.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));
    }


    public void patientButtonOnAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));

        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));

    }

    public void backButton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));

    }
}