package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class DoctorAppointmentsPageController {

    private static String username;
    private String currentSelectedItem;

    @FXML
    private ListView<String> listView;

    public static void setUsername(String username) {
        DoctorAppointmentsPageController.username = username;
    }

    public void setListView(List<String> list) {
        listView.getItems().addAll(list);


    }
    public void listViewSelectedItem() {

        currentSelectedItem = listView.getSelectionModel().getSelectedItem();


    }

}
