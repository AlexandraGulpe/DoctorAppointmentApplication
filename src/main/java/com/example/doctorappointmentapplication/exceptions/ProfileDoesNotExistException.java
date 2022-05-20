package com.example.doctorappointmentapplication.exceptions;

public class ProfileDoesNotExistException extends Exception{
    private String username;

    public ProfileDoesNotExistException(String username) {
        super(String.format("A profile with this phone number %s does not exist!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
