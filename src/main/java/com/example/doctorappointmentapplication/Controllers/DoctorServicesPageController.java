package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.HelloApplication;
import com.example.doctorappointmentapplication.services.DoctorFacilitiesService;
import com.example.doctorappointmentapplication.exceptions.ServiceAlreadyExistsException;
import com.example.doctorappointmentapplication.exceptions.ServiceDoesNotExistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;


public class DoctorServicesPageController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField priceField;

    @FXML
    private Text addMessage;

    @FXML
    private Text addDeleteMessage;

    @FXML
    private TextField deletedNameField;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField editNameField;

    @FXML
    private TextField editDescriptionField;

    @FXML
    private TextField editPriceField;

    @FXML
    private Button backButton;



    private String username;

    public void setUsername(String username){
        this.username = username;
    }
    public void setListView(List<String> lst) {
        listView.getItems().addAll(lst);
    }

    public void handleAddServiceAction(){
        try{
            DoctorFacilitiesService.addService(DoctorFacilitiesService.getNextId(),nameField.getText(),descriptionField.getText(),priceField.getText(), username);
            addMessage.setText("Service added");
            listView.getItems().addAll("Service: " + nameField.getText() + "\nDescription: " + descriptionField.getText() + "\nPrice: " + priceField.getText());

        }catch (ServiceAlreadyExistsException e){
            addMessage.setText(e.getMessage());
        }
    }


    public void handleDeleteServiceOnAction() {
        try {
            addDeleteMessage.setText("Service deleted");
            String str = DoctorFacilitiesService.deleteLista(username, deletedNameField.getText());
            listView.getItems().remove(str);

        }catch (ServiceDoesNotExistException e){
            addMessage.setText(e.getMessage());
        }

    }

    public void handleChangeDescriptionAction() {
        try {
            DoctorFacilitiesService.changeDescription(editNameField.getText(), username, editDescriptionField.getText());
            addMessage.setText("Property Description Changed Successfully");
        } catch (ServiceDoesNotExistException e) {
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
