package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.exceptions.ProfileAlreadyExistsException;
import com.example.doctorappointmentapplication.exceptions.ServiceAlreadyExistsException;
import com.example.doctorappointmentapplication.services.DoctorFacilitiesService;
import com.example.doctorappointmentapplication.services.ProfileService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.List;

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

    @FXML
    private Text addMessage;


    private String username;

    public void setUsername(String username){
        this.username = username;
    }
    public void setListView(List<String> lst) {
        listView.getItems().addAll(lst);
    }


    public void handleAddProfileAction(){
        try{
            ProfileService.addProfile(ProfileService.getNextId(),phoneField.getText(),emailField.getText(),languageField.getText(),educationField.getText(),workField.getText(), username);
            addMessage.setText("Information was saved in your profile");
            listView.getItems().addAll(phoneField.getText() + "; " + emailField.getText() + "; " + languageField.getText() + "; " + educationField.getText() + "; " + workField.getText());

        }catch (ProfileAlreadyExistsException e){
            addMessage.setText(e.getMessage());
        }
    }


}
