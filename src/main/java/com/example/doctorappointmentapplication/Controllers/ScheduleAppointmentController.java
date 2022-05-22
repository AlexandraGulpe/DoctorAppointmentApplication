package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.exceptions.UsernameAlreadyExistsException;
import com.example.doctorappointmentapplication.model.Appointment;
import com.example.doctorappointmentapplication.services.UserService;
import com.example.doctorappointmentapplication.services.AppointmentService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class ScheduleAppointmentController {

    private String patientUsername;
    private String doctorUsername;

    private String doctorName;

    public void setUsername(String patientUsername,String doctorUsername ,String doctorName){

        this.patientUsername = patientUsername;
        this.doctorUsername=doctorUsername;
        this.doctorName = doctorName;

    }

    @FXML
    private TextField dayField;

    @FXML
    private TextField monthField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField hourField;

    @FXML
    private Text scheduledMessage;

    @FXML
    private Button ScheduleButton;

    @FXML
    public void handleScheduleOnAction() {
        try {
           AppointmentService.scheduleAppointment(AppointmentService.getLastId()+1, patientUsername,doctorUsername,doctorName,dayField.getText(),monthField.getText(),yearField.getText(),hourField.getText());
            scheduledMessage.setText("Appointment request created successfully!");

        } catch (Exception e) {
            scheduledMessage.setText(e.getMessage());
        }



    }




}
