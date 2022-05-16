module com.example.doctorappointmentapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;


    opens com.example.doctorappointmentapplication to javafx.fxml;
    exports com.example.doctorappointmentapplication;
}