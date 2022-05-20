package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.HelloApplication;
import com.example.doctorappointmentapplication.services.UserService;
import com.example.doctorappointmentapplication.exceptions.UsernameAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

public class RegistrationController{

    @FXML
    private ChoiceBox<String> role;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private Label specialtyLabel;

    @FXML
    private TextField specialtyTextField;

    @FXML
    private Button registrationButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Text registrationMessage;

    @FXML
    private Button toLoginButton;




    @FXML
    public void initialize() {

        role.getItems().addAll("Doctor", "Patient");
        role.setValue("Doctor");

    }

    public void onChange(){
        String s = role.getValue();
        if(s.equals("Doctor")){
            specialtyTextField.setVisible(true);
            specialtyLabel.setVisible(true);
        }else if(s.equals("Patient"))
        {
            specialtyTextField.setVisible(false);
            specialtyLabel.setVisible(false);
        }
    }

    public void cancelButton(ActionEvent event) throws Exception{
        URL adrr = HelloApplication.class.getResource("hello-view.fxml");


        Parent root = FXMLLoader.load(adrr);
        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));

    }

    public void toLoginButtonOnAction(ActionEvent event) throws  Exception{
        URL adrr = HelloApplication.class.getResource("login.fxml");


        Parent root = FXMLLoader.load(adrr);
        Stage window = (Stage) toLoginButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));

    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(), nameField.getText(), specialtyTextField.getText() );
            registrationMessage.setText("Account created successfully!");

        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }



    }
}

