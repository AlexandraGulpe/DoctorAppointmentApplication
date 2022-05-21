package com.example.doctorappointmentapplication.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

import com.example.doctorappointmentapplication.services.ProfileService;
import com.example.doctorappointmentapplication.services.DoctorFacilitiesService;

public class ViewDoctorProfilePageController {

    private String username;

    public void setUsername(String username) {
        this.username = username;

    }

    @FXML
    private ListView<String> listView;

    public void setListView(){
        listView.getItems().addAll(ProfileService.getLista(username));
        listView.getItems().addAll("Services: \n");
        listView.getItems().addAll(DoctorFacilitiesService.getLista(username));


    }


}
