package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.net.URL;


public class HelloController {

    @FXML
    private Label labelField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    public void loginButtonOnAction(ActionEvent event) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage window = (Stage) loginButton.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));*/

        URL adr = HelloApplication.class.getResource("login.fxml");

        try {
            Parent root = FXMLLoader.load(adr);
            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setScene(new Scene(root, 1200, 800));
        } catch (Exception e) {
            System.out.println(adr);
        }
    }

    public void registerButtonOnAction(ActionEvent event) throws Exception {

        URL adr2 = HelloApplication.class.getResource("register.fxml");


        Parent root = FXMLLoader.load(adr2);
        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));

    }
}