package com.example.doctorappointmentapplication.services;

import com.example.doctorappointmentapplication.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import com.example.doctorappointmentapplication.exceptions.UsernameAlreadyExistsException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static com.example.doctorappointmentapplication.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        System.out.println(getPathToFile("registration-example2.db").toFile());
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example2.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role, String fullName, String speciality) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role, fullName, speciality));
    }

    public static boolean checkUserCredentials(String username, String password){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())){
                if(user.getPassword().equals(encodePassword(username,password)))
                    return true;

            }

        }
        return false;
    }


    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static String checkRole(String username){
        for(User user : userRepository.find()){
            if (Objects.equals(username, user.getUsername())){
                return user.getRole();
            }
        }
        return "";
    }

    /*
    public static String checkName(String username){
        for(User user : userRepository.find()){
            if(Objects.equals(username, user.getUsername())){
                return user.getFullName();
            }
        }

        return "";
    }*/


    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}