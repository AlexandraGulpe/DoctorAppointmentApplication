package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.exceptions.NoAppointmentSelectedException;
import com.example.doctorappointmentapplication.services.AppointmentService;
import com.example.doctorappointmentapplication.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.List;

public class DoctorAppointmentsPageController {

    private static String username;
    private String currentSelectedItem;

    @FXML
    private ListView<String> listView;

    @FXML
    private Text addMessage;

    private int currentID;

    public static void setUsername(String username) {
        DoctorAppointmentsPageController.username = username;
    }

    public void setListView(List<String> list) {
        listView.getItems().addAll(list);


    }
    public void listViewSelectedItem() {

        currentSelectedItem = listView.getSelectionModel().getSelectedItem();
        currentID = AppointmentService.findID(currentSelectedItem);

    }

    public void handleClickAcceptAction() {
        try {
            AppointmentService.setAppointmentStatus(currentID,"Accepted");
            listView.getItems().remove(currentSelectedItem);
            addMessage.setText("Accepted appointment succsefully");
        } catch (Exception e) {
            addMessage.setText(e.getMessage());
        }
    }

    public void handleClickDenyAction(){
        try{

            AppointmentService.setAppointmentStatus(currentID,"Denied");
            listView.getItems().remove(currentSelectedItem);

        }catch (Exception e){
            addMessage.setText(e.getMessage());
        }



    }

}
