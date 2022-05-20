package com.example.doctorappointmentapplication.exceptions;

public class ServiceDoesNotExistException extends Exception{
    private String username;

    public ServiceDoesNotExistException(String username) {
        super(String.format("A service with the name %s does not exist!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
