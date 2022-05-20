package com.example.doctorappointmentapplication.model;


import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class DoctorServices  {
    @Id
    private int id;
    private String service;
    private String description;
    private String price;
    private String username;

    public DoctorServices(int id,String service, String description, String price, String username){
        this.id = id;
        this.service = service;
        this.description = description;
        this.price = price;
        this.username = username;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorServices service = (DoctorServices) o;
        return Objects.equals(description, service.description) && Objects.equals(price, service.price) && Objects.equals(service, service.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
