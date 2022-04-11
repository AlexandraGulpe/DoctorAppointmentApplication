module com.example.doctorappointmentapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.doctorappointmentapplication to javafx.fxml;
    exports com.example.doctorappointmentapplication;
}