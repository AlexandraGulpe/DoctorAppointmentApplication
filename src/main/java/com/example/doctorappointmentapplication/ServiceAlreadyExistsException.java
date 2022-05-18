package com.example.doctorappointmentapplication;

public class ServiceAlreadyExistsException extends Exception{
    private String service;

    public ServiceAlreadyExistsException(String service) {
        super(String.format("An account with the username %s already exists!", service));
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
