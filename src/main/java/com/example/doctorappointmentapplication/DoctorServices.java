package com.example.doctorappointmentapplication;

import org.dizitart.no2.RemoveOptions;
import org.dizitart.no2.objects.Id;

public class DoctorServices extends RemoveOptions {
    @Id
    private String service;
    private String description;
    private int price;

    public DoctorServices(String service, String description, int price){
        this.service = service;
        this.description = description;
        this.price = price;
    }

    public DoctorServices(){

    }


    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
