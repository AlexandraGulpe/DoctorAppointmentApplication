package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.services.ProfileService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import com.example.doctorappointmentapplication.Controllers.DoctorPageController;

import java.io.IOException;
import java.util.List;

import com.example.doctorappointmentapplication.services.UserService;
import com.example.doctorappointmentapplication.model.User;

public class DoctorListController {

    @FXML
    private ListView <String> listView;

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setListView(List <String> list){

        listView.getItems().addAll(UserService.getDoctorList());


    }

    @FXML
    private Button DoctorProfilePageButton;

    @FXML
    private Button ScheduleAppointment;

    @FXML
    public String currentSelectedItem;
    private String username1;
    private String doctorName;

    public void listViewSelectedItem() {

        currentSelectedItem = listView.getSelectionModel().getSelectedItem();
        username1 = UserService.findUsername(currentSelectedItem);
        doctorName = UserService.findFullName(currentSelectedItem);


    }



   public void DoctorProfilePageButtonOnAction() throws Exception{
        Parent root;
        try {
            //root = FXMLLoader.load(adrr);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/viewDoctorProfilePage.fxml"));
            root = (Parent)loader.load();
            ViewDoctorProfilePageController viewDoctorProfilePageController = loader.getController();
            viewDoctorProfilePageController.setUsername(username1);
            viewDoctorProfilePageController.setListView();
            Stage stage = new Stage();
            stage.setTitle(doctorName + " Profile");
            stage.setScene(new Scene(root, 1200, 800));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ScheduleAppointmentButtonOnAction() throws Exception{
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/scheduleAppointment.fxml"));
            root = (Parent)loader.load();
           ScheduleAppointmentController scheduleAppointmentController = loader.getController();
            scheduleAppointmentController.setUsername(username,username1);
            Stage stage = new Stage();
            stage.setTitle("Schedule Appointment for doctor: "+ doctorName);
            stage.setScene(new Scene(root, 1200, 800));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        }
}
