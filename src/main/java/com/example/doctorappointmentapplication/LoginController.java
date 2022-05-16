package com.example.doctorappointmentapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController{

    @FXML
    private Button cancelButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;


    public void loginButtonOnAction(ActionEvent event){

        if(!usernameField.getText().isBlank() && !passwordField.getText().isBlank()){
            errorLabel.setText("You try to login.");
        } else {
            errorLabel.setText("Please enter username and password.");
        }



    }

    public void cancelButton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));

    }


}
