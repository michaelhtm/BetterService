package com.mvc.scheduling;
 
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
 
@Service("appointmentService")
public class AppointmentService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String MICROURL = "http://localhost:8011/";
    
    public String saveAppointment (Appointment appointment) {
        try{
            return restTemplate.postForObject(MICROURL+"saveAppointment", appointment, String.class).strip();
        }catch(Exception e) {
            return null;
        }
        
    }

    public List<Appointment> getAppointmentsForCustomer(String customerId) {

        try{
            Appointment[] appointments = restTemplate.getForObject(
                MICROURL + "viewAllAppointments?customerId="+customerId,
                Appointment[].class);
            return Arrays.asList(appointments);
        }catch(Exception e) {
            return null;
        }
    }

    public Appointment getAppointment(String id) {
        try{
            return restTemplate.getForObject(
                MICROURL + "getAppointment?appointmentId="+id,
                Appointment.class
            );
        }catch(Exception e) {
            return null;
        }
    }
}
