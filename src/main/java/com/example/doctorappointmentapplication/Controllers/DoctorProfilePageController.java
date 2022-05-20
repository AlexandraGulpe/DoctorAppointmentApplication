package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.HelloApplication;
import com.example.doctorappointmentapplication.exceptions.ProfileAlreadyExistsException;
import com.example.doctorappointmentapplication.exceptions.ProfileDoesNotExistException;
import com.example.doctorappointmentapplication.exceptions.ServiceAlreadyExistsException;
import com.example.doctorappointmentapplication.exceptions.ServiceDoesNotExistException;
import com.example.doctorappointmentapplication.services.DoctorFacilitiesService;
import com.example.doctorappointmentapplication.services.ProfileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
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

    @FXML
    private TextField deleteInfoTextField;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    @FXML
    private Text addDeleteMessage;


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
            System.out.println("ceau");
            addMessage.setText("Information was saved in your profile");
            listView.getItems().addAll("Phone Number: " + phoneField.getText() + "\n" + "Email Address: " + emailField.getText() + "\n"+ "Languages: " + languageField.getText() + "\n"+ "Education: " + educationField.getText() + "\n"+"Work Experience: " + workField.getText());

        }catch (ProfileAlreadyExistsException e){
            addMessage.setText(e.getMessage());
        }
    }

    public void handleDeleteServiceOnAction() {
        try {
            addDeleteMessage.setText("Information on the profile was deleted");
            String str = ProfileService.deleteLista(username, deleteInfoTextField.getText());
            listView.getItems().remove(str);

        }catch (ProfileDoesNotExistException e){
            addMessage.setText(e.getMessage());
        }

    }

    public void backButtonOnAction(ActionEvent event) throws  Exception{
        URL adrr = HelloApplication.class.getResource("doctorPage.fxml");


        Parent root = FXMLLoader.load(adrr);
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));

    }




}
