package com.example.doctorappointmentapplication.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class AppointmentHistoryController {

    @FXML
    private ListView<String> listView;

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setListView(List<String> list) {
        listView.getItems().addAll(list);


    }
}