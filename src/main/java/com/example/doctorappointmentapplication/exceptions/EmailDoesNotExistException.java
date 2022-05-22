package com.example.doctorappointmentapplication.exceptions;

public class EmailDoesNotExistException extends Exception{
    private String email;

    public EmailDoesNotExistException(String email) {
        super(String.format("A profile with this email address %s does not exist!",email));
        this.email = email;
    }

    public String getUsername() {
        return email;
    }
}
