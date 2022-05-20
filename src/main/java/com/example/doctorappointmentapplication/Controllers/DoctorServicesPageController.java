package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.services.DoctorFacilitiesService;
import com.example.doctorappointmentapplication.exceptions.ServiceAlreadyExistsException;
import com.example.doctorappointmentapplication.exceptions.ServiceDoesNotExistException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
            listView.getItems().addAll(nameField.getText() + " " + descriptionField.getText() + " " + priceField.getText());

        }catch (ServiceAlreadyExistsException e){
            addMessage.setText(e.getMessage());
        }
    }


    public void handleDeleteServiceOnAction() {
        //DoctorFacilitiesService.deleteService(deletedNameField.getText());
        try {
            addDeleteMessage.setText("Service deleted");
            String str = DoctorFacilitiesService.deleteLista(username, deletedNameField.getText());
            listView.getItems().remove(str);

        }catch (ServiceDoesNotExistException e){
            addMessage.setText(e.getMessage());
        }

    }


}
