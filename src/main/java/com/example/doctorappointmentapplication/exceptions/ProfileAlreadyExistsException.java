package com.example.doctorappointmentapplication.exceptions;

public class ProfileAlreadyExistsException extends Exception{
    private String email;

    public ProfileAlreadyExistsException(String email) {
        super(String.format("A profile with the email %s already exists!", email));
        this.email = email;
    }

    public String getProfile() {
        return email;
    }

}
