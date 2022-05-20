package com.example.doctorappointmentapplication.exceptions;

public class ProfileAlreadyExistsException extends Exception{
    private String phone;

    public ProfileAlreadyExistsException(String phone) {
        super(String.format("A profile with the phone number %s already exists!", phone));
        this.phone = phone;
    }

    public String getProfile() {
        return phone;
    }

}
