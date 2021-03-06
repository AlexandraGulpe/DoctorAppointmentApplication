package com.example.doctorappointmentapplication.Controllers;

import com.example.doctorappointmentapplication.HelloApplication;
import com.example.doctorappointmentapplication.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class LoginController{

    @FXML
    private Button cancelButton;

    @FXML
    private Text loginMessage;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;



    @FXML
    public void handleLoginAction() {

        if (UserService.checkUserCredentials(usernameField.getText(), passwordField.getText())) {

            //URL adrr = HelloApplication.class.getResource("doctorPage.fxml");
            URL adrr2 = HelloApplication.class.getResource("patientPage.fxml");

            String role = UserService.checkRole(usernameField.getText());
            Parent root = null;
            Parent root2 = null;


            if(Objects.equals(role, "Doctor")) {
                try {
                    //root = FXMLLoader.load(adrr);
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/doctorPage.fxml"));
                    root = (Parent)loader.load();
                    DoctorPageController doctorPageController = loader.getController();
                    doctorPageController.setUsername(usernameField.getText());
                    Stage stage = new Stage();
                    stage.setTitle("DoctorPage");
                    stage.setScene(new Scene(root, 1200, 800));
                    stage.show();
                   /* Stage window = (Stage) loginButton.getScene().getWindow();
                    window.setScene(new Scene(root, 1200, 800));*/
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    //root = FXMLLoader.load(adrr);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doctorappointmentapplication/patientPage.fxml"));
                    root = (Parent)loader.load();
                    PatientPageController patientPageController = loader.getController();
                    patientPageController.setUsername(usernameField.getText());
                    Stage stage = new Stage();
                    stage.setTitle("PatientPage");
                    stage.setScene(new Scene(root, 1200, 800));
                    stage.show();
                   /* Stage window = (Stage) loginButton.getScene().getWindow();
                    window.setScene(new Scene(root, 1200, 800));*/
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else{
                loginMessage.setText("Invalid credentials");
            }
        }


    public void cancelButton(ActionEvent event) throws Exception{
        URL adrr = HelloApplication.class.getResource("hello-view.fxml");


        Parent root = FXMLLoader.load(adrr);
        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 800));

    }


}
