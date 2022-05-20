package com.example.doctorappointmentapplication.services;

import com.example.doctorappointmentapplication.exceptions.ProfileAlreadyExistsException;
import com.example.doctorappointmentapplication.model.DoctorProfile;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfileService {

    private static ObjectRepository<DoctorProfile> profileRepository;


    public static void initDatabase() {

        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("profile.db").toFile())
                .openOrCreate("simple", "simple");

        profileRepository = database.getRepository(DoctorProfile.class);
    }


    public static List<DoctorProfile> getAllProfile() {

        return profileRepository.find().toList();
    }

    public static void addProfile(int id, String phone, String email, String language, String education, String work, String username) throws ProfileAlreadyExistsException {
        checkProfileDoesNotAlreadyExist(email);
        profileRepository.insert(new DoctorProfile(id,phone, email, language,education, work,username));
    }

    private static void checkProfileDoesNotAlreadyExist(String email) throws ProfileAlreadyExistsException {
        for (DoctorProfile profile : profileRepository.find()) {
            if (Objects.equals(email, profile.getEmail()));
                throw new ProfileAlreadyExistsException(email);
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
                list.add(profile.getPhone() + " " + profile.getEmail() + " " + profile.getLanguage() + " " + profile.getEducation() + " " + profile.getWork());
            }

        }
        return list;
    }
}
