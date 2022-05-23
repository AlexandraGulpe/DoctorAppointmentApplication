package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.exceptions.NoAppointmentSelectedException;
import com.example.doctorappointmentapplication.exceptions.NoDoctorCommentAddedException;
import com.example.doctorappointmentapplication.services.AppointmentService;
import com.example.doctorappointmentapplication.services.UserService;
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

import java.util.List;
import java.util.Objects;

public class DoctorAppointmentsPageController {

    private static String username;
    private String currentSelectedItem=null;

    @FXML
    private ListView<String> listView;

    @FXML
    private Text addMessage;

    @FXML
    private Text errorMessage;

    @FXML
    private TextField doctorComment;

    @FXML
    private Button backButton;


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

    public void noCommentAddedException() throws NoDoctorCommentAddedException {
        if(Objects.equals(doctorComment.getText(),"")){
            throw new NoDoctorCommentAddedException();

        }
    }

    public void noAppointmentSelectedException() throws NoAppointmentSelectedException{
        if(currentSelectedItem == null){
            throw new NoAppointmentSelectedException();
        }

    }



    public void handleClickAcceptAction() {
        try {
            noAppointmentSelectedException();
            noCommentAddedException();

            AppointmentService.setAppointmentStatus(currentID,"Accepted","Observation: " + doctorComment.getText());
            listView.getItems().remove(currentSelectedItem);
            addMessage.setText("Accepted appointment successfully");

            currentSelectedItem=null;

        }catch (NoAppointmentSelectedException e){
            errorMessage.setText(e.getMessage());

        } catch(NoDoctorCommentAddedException e){
            errorMessage.setText(e.getMessage());
        }

    }

    public void handleClickDenyAction(){
        try{
            noAppointmentSelectedException();
            noCommentAddedException();

            AppointmentService.setAppointmentStatus(currentID,"Denied","Reason: " + doctorComment.getText());
            listView.getItems().remove(currentSelectedItem);
            addMessage.setText("Removed appointment successfully");

            currentSelectedItem=null;

        }catch (NoAppointmentSelectedException e){
            errorMessage.setText(e.getMessage());

        }catch(NoDoctorCommentAddedException e){
            errorMessage.setText(e.getMessage());
        }

    }

    public void backButtonOnAction(ActionEvent event) throws  Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/doctorPage.fxml"));
        Parent root = loader.load();
        DoctorPageController doctorPageController = loader.getController();
        doctorPageController.setUsername(username);

        Stage window =(Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));

    }

}
