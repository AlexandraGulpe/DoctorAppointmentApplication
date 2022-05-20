package com.example.doctorappointmentapplication;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class DoctorProfile {
    @Id
    private int id;
    private String phone;
    private String email;
    private String language;
    private String education;
    private String work;
    private String username;


    public DoctorProfile(int id, String phone, String email, String language, String education, String work, String username) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.language = language;
        this.education = education;
        this.work = work;
        this.username = username;
    }

    public DoctorProfile(){

    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorProfile profile = (DoctorProfile) o;
        return Objects.equals(phone, profile.phone) && Objects.equals(email, profile.email) && Objects.equals(language, profile.language) && Objects.equals(education, profile.education) && Objects.equals(work, profile.work) ;
    }
}
