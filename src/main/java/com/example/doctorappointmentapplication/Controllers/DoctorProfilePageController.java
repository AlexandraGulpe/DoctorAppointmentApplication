package com.example.doctorappointmentapplication.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DoctorProfilePageController {

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField languageField;

    @FXML
    private TextField educationField;

    @FXML
    private TextField workField;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button saveButton;


}
