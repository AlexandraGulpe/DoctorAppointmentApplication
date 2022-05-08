package com.example.doctorappointmentapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
public class HelloApplication extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Parent root = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        //StackPane root = new StackPane();
        //root.setId("stack-pane");
        Scene scene = new Scene(root, 1200, 800);
        //root.setStyle("-fx-background-image:url('test.png'); -fx-background-repeat: no-repeat; -fx-background-position: center center; -fx-background-size: stretch;");
        //primaryStage.getIcons().add(new Image("file: icon.png"));
        //scene.getStylesheets().add(String.valueOf(this.getClass().getResource("style.css")));

        primaryStage.setTitle("Doctor Appointment Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
