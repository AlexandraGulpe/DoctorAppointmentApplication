package com.example.doctorappointmentapplication.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ScheduleAppointmentController {

    private String patientUsername;

    private String doctorUsername;

    public void setUsername(String patientUsername, String doctorUsername){

        this.patientUsername = patientUsername;
        this.doctorUsername = doctorUsername;

    }

    @FXML
    private TextField dayField;

    @FXML
    private TextField monthField;

    @FXML
    private TextField hourField;

    @FXML
    private Button ScheduleButton;


}
