package com.example.doctorappointmentapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static com.example.doctorappointmentapplication.FileSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.and;

import com.example.doctorappointmentapplication.User;
import com.example.doctorappointmentapplication.DoctorServices;
import com.example.doctorappointmentapplication.ServiceAlreadyExistsException;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;


public class DoctorFacilitiesService {

    private static ObjectRepository<DoctorServices> serviceRepository;


    public static void initDatabase() {

        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("services2.db").toFile())
                .openOrCreate("simple", "simple");

       serviceRepository = database.getRepository(DoctorServices.class);
    }


    public static List<DoctorServices> getAllServices() {

        return serviceRepository.find().toList();
    }

    public static void addService(int id, String service, String description, String price, String username) throws ServiceAlreadyExistsException {
        checkServiceDoesNotAlreadyExist(service);
        serviceRepository.insert(new DoctorServices(id,service, description, price,username));
    }

    public static int getNextId(){
        int id = 0;
        for (DoctorServices service : serviceRepository.find()){
            id = id > service.getId() ? id : service.getId();
        }
        return (id+1);
    }

    public static List<String> getLista(String username){
        List<String> list = new ArrayList<String>();
        for (DoctorServices service : serviceRepository.find()){
            if(Objects.equals(username, service.getUsername())){
                list.add(service.getService() + " " + service.getDescription() + " " + service.getPrice());
            }

        }
        return list;
    }

    private static void checkServiceDoesNotAlreadyExist(String name) throws ServiceAlreadyExistsException {
        for (DoctorServices service : serviceRepository.find()) {
            if (Objects.equals(name, service.getService()))
                throw new ServiceAlreadyExistsException(name);
        }
    }

    public static String deleteLista(String username, String serviceName) throws ServiceDoesNotExistException{
        String str =  "";
        for (DoctorServices service : serviceRepository.find()){
            if(Objects.equals(serviceName, service.getService()) && Objects.equals(username, service.getUsername())){
                str = service.getService() + " " + service.getDescription() + " " + service.getPrice();
                serviceRepository.remove(service);
            }
        }
        if(str == "") throw new ServiceDoesNotExistException(serviceName);
        return str;

    }

    public static List<String> getAllServices(String username){
        List <String> list = new ArrayList<String>();
        for(DoctorServices service : serviceRepository.find()){
            if(Objects.equals(username,service.getService())){
                list.add(service.getService() + '/' + service.getDescription() + '/' + service.getPrice());
            }
        }
        return list;
    }

    public static DoctorServices getServiceByName(String name){
        DoctorServices sol=new DoctorServices();
        for(DoctorServices service:serviceRepository.find())
            if(Objects.equals(name,service.getService()))
                sol=service;
        return sol;

    }

    public static void deleteService(String name) throws ServiceDoesNotExistException {
        int ok = 0;
        for (DoctorServices service : serviceRepository.find()) {
            if (Objects.equals(name, service.getService())) {
                serviceRepository.remove(service);
                ok = 1;
            }
        }
        if (ok == 0)
            throw new ServiceDoesNotExistException(name);
    }
    public static List<DoctorServices> getAll(){
        return serviceRepository.find().toList();
    }

    /*
    public static void deleteService(String service, String description) {
        DoctorServices service_aux = new DoctorServices();

        for (DoctorServices name : serviceRepository.find()) {
            if (service.equals(name.getService()) && description.equals(name.getDescription())) {
                service_aux = name;
            }
        }

        serviceRepository.remove(and(eq("service name",service),eq("description", description)), service_aux);
    }*/


}
