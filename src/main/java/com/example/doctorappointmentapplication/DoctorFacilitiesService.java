package com.example.doctorappointmentapplication;

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
    public static ObjectRepository<DoctorServices> getServicesRepository() {
        return serviceRepository;
    }

    public static void initDatabase() {
        System.out.println(getPathToFile("services.db").toFile());
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("services.db").toFile())
                .openOrCreate("test", "test");

       serviceRepository = database.getRepository(DoctorServices.class);
    }


    public static List<DoctorServices> getAllServices() {

        return serviceRepository.find().toList();
    }

    public static void addService(String service, String description, int price) throws ServiceAlreadyExistsException {
        checkServiceDoesNotAlreadyExist(service);
        serviceRepository.insert(new DoctorServices(service, description, price));
    }


    private static void checkServiceDoesNotAlreadyExist(String service_name) throws ServiceAlreadyExistsException {
        for (DoctorServices service : serviceRepository.find()) {
            if (Objects.equals(service_name, service.getService()))
                throw new ServiceAlreadyExistsException(service_name);
        }
    }

    public static void deleteService(String service, String description) {
        DoctorServices service_aux = new DoctorServices();

        for (DoctorServices name : serviceRepository.find()) {
            if (service.equals(name.getService()) && description.equals(name.getDescription())) {
                service_aux = name;
            }
        }

        serviceRepository.remove(and(eq("service name",service),eq("description", description)), service_aux);
    }


}
