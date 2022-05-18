package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.DoctorFacilitiesService;
import com.example.doctorappointmentapplication.DoctorServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.IOException;


public class DoctorServicesPageController {

    private static ObjectRepository<DoctorServices> servicesRepository = DoctorFacilitiesService.getServicesRepository();

    @FXML
    private TextField description;

    @FXML
    private ListView<String> serviceListView = new ListView<String>();

    @FXML
    public void initialize() throws IOException {
        //updateListView();
    }



}
