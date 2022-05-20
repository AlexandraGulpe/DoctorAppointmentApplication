package com.example.doctorappointmentapplication.Controllers;
import com.example.doctorappointmentapplication.HelloApplication;

import com.example.doctorappointmentapplication.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.*;
import java.net.URL;
import java.util.ArrayList;
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