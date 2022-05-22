package com.example.doctorappointmentapplication.services;

import com.example.doctorappointmentapplication.HelloApplication;
import com.example.doctorappointmentapplication.exceptions.ProfileAlreadyExistsException;
import com.example.doctorappointmentapplication.exceptions.ProfileDoesNotExistException;
import com.example.doctorappointmentapplication.exceptions.ServiceDoesNotExistException;
import com.example.doctorappointmentapplication.model.DoctorProfile;
import com.example.doctorappointmentapplication.model.DoctorServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfileService {

    private static ObjectRepository<DoctorProfile> profileRepository;


    public static void initDatabase() {

        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("profile3.db").toFile())
                .openOrCreate("simple", "simple");

        profileRepository = database.getRepository(DoctorProfile.class);
    }


    public static List<DoctorProfile> getAllProfile() {

        return profileRepository.find().toList();
    }

    public static void addProfile(int id, String phone, String email, String language, String education, String work, String username) throws ProfileAlreadyExistsException {
        checkProfileDoesNotAlreadyExist(phone);
        profileRepository.insert(new DoctorProfile(id,phone, email, language,education, work,username));
    }

    private static void checkProfileDoesNotAlreadyExist(String name) throws ProfileAlreadyExistsException {
        for (DoctorProfile profile : profileRepository.find()) {
            if (Objects.equals(name, profile.getPhone()))
                throw new ProfileAlreadyExistsException(name);
        }
    }

    public static int getNextId(){
        int id = 0;
        for (DoctorProfile profile : profileRepository.find()){
            id = id > profile.getId() ? id : profile.getId();
        }
        return (id+1);
    }

    public static List<String> getLista(String username){
        List<String> list = new ArrayList<String>();
        for (DoctorProfile profile : profileRepository.find()){
            if(Objects.equals(username, profile.getUsername())){
                list.add("Phone Number: " + profile.getPhone() + "\n" + "Email Address: " + profile.getEmail() + "\n"+ "Languages: " + profile.getLanguage() + "\n"+ "Education: " + profile.getEducation() + "\n"+"Work Experience: " + profile.getWork());
            }

        }
        return list;
    }

    public static String deleteLista(String username, String mail) throws ProfileDoesNotExistException {
        String str =  "";
        for (DoctorProfile profile : profileRepository.find()){
            if(Objects.equals(mail, profile.getEmail()) && Objects.equals(username, profile.getUsername())){
                str = "Phone Number: " + profile.getPhone() + "\n" + "Email Address: " + profile.getEmail() + "\n"+ "Languages: " + profile.getLanguage() + "\n"+ "Education: " + profile.getEducation() + "\n"+"Work Experience: " + profile.getWork();
                profileRepository.remove(profile);
            }
        }
        if(str == "") throw new ProfileDoesNotExistException(mail);
        return str;

    }

    public static void changePhone(String username, String phone) throws ProfileDoesNotExistException {
        int ok = 0;
        for (DoctorProfile profile : profileRepository.find()) {
            if (Objects.equals(username,profile.getUsername()) ) {
                profile.setPhone(phone);
                profileRepository.update(profile);
                ok = 1;
            }
        }
        if (ok == 0)
            throw new ProfileDoesNotExistException(phone);
    }

}
