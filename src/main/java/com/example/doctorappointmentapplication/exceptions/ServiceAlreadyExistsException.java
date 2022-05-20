package com.example.doctorappointmentapplication.exceptions;

public class ServiceAlreadyExistsException extends Exception{
    private String service;

    public ServiceAlreadyExistsException(String service) {
        super(String.format("A service with the username %s already exists!", service));
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
