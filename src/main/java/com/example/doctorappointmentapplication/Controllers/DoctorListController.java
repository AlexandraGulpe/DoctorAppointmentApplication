package com.example.doctorappointmentapplication.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import com.example.doctorappointmentapplication.services.UserService;

public class DoctorListController {

    @FXML
    private ListView <String> listView;

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setListView(List <String> list){
        listView.getItems().addAll(list);


    }

    @FXML
    private Button DoctorInfoButton;

    @FXML
    private Button ScheduleAppointment;

 /*   public void DoctorInfoButtonOnAction() throws Exception{
        Parent root;
        try {
            //root = FXMLLoader.load(adrr);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/appointmentHistory.fxml"));
            root = (Parent)loader.load();
            Doctor appointmentHistoryController = loader.getController();
            appointmentHistoryController.setUsername(username);
            // appointmentHistoryController.setListView(UserService.getAppointmentList);
            Stage stage = new Stage();
            stage.setTitle("Appointment History");
            stage.setScene(new Scene(root, 1200, 800));
            stage.show();
                    // Stage window = (Stage) loginButton.getScene().getWindow();
                   // window.setScene(new Scene(root, 1200, 800));
        } catch (IOException e) {
            e.printStackTrace();
        }

    } */


}
