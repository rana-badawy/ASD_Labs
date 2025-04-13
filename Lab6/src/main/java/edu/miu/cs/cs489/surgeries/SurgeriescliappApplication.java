package edu.miu.cs.cs489.surgeries;

import edu.miu.cs.cs489.surgeries.model.*;
import edu.miu.cs.cs489.surgeries.service.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class SurgeriescliappApplication {

    private final AddressService addressService;
    private final SurgeryService surgeryService;
    private final DentistService dentistService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;

    public SurgeriescliappApplication(AddressService addressService,
                                      SurgeryService surgeryService,
                                      DentistService dentistService,
                                      PatientService patientService,
                                      AppointmentService appointmentService) {
        this.addressService = addressService;
        this.surgeryService = surgeryService;
        this.dentistService = dentistService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SurgeriescliappApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Surgery surgery1 = new Surgery(
                    "S15");

            Surgery surgery2 = new Surgery(
                    "S10");

            Surgery surgery3 = new Surgery(
                    "S13");


            Dentist dentist1 = new Dentist(
                    "Tony",
                    "Smith",
                    "1515474151"
            );

            Dentist dentist2 = new Dentist(
                    "Helen",
                    "Pearson",
                    "1515474151"
            );

            Dentist dentist3 = new Dentist(
                    "Robin",
                    "Plevin",
                    "1515474151"
            );


            Patient patient1 = new Patient(
                    "Gillian",
                    "White",
                    "1515474151"
            );

            Patient patient2 = new Patient(
                    "Jill",
                    "Bell",
                    "1515474151"
            );

            Patient patient3 = new Patient(
                    "Ian",
                    "McKay",
                    "1515474151"
            );

            Patient patient4 = new Patient(
                    "John",
                    "Walker",
                    "1515474151"
            );


            Surgery savedSurgery1 = surgeryService.addSurgery(surgery1).get();
            Surgery savedSurgery2 = surgeryService.addSurgery(surgery2).get();
            Surgery savedSurgery3 = surgeryService.addSurgery(surgery3).get();

            Dentist savedDentist1 = dentistService.addDentist(dentist1).get();
            Dentist savedDentist2 = dentistService.addDentist(dentist2).get();
            Dentist savedDentist3 = dentistService.addDentist(dentist3).get();

            Patient savedPatient1 = patientService.addPatient(patient1).get();
            Patient savedPatient2 = patientService.addPatient(patient2).get();
            Patient savedPatient3 = patientService.addPatient(patient3).get();
            Patient savedPatient4 = patientService.addPatient(patient4).get();



            Appointment appointment = new Appointment(
                    LocalDate.of(2013, 9, 12),
                    LocalTime.of(10, 0),
                    savedSurgery1,
                    savedDentist1,
                    savedPatient1
            );

            Appointment appointment2 = new Appointment(
                    LocalDate.of(2013, 9, 12),
                    LocalTime.of(12, 0),
                    savedSurgery1,
                    savedDentist1,
                    savedPatient2
            );

            Appointment appointment3 = new Appointment(
                    LocalDate.of(2013, 9, 12),
                    LocalTime.of(10, 0),
                    savedSurgery2,
                    savedDentist2,
                    savedPatient3
            );

            Appointment appointment4 = new Appointment(
                    LocalDate.of(2013, 9, 14),
                    LocalTime.of(14, 0),
                    savedSurgery2,
                    savedDentist2,
                    savedPatient3
            );

            Appointment appointment5 = new Appointment(
                    LocalDate.of(2013, 9, 14),
                    LocalTime.of(16, 0),
                    savedSurgery1,
                    savedDentist3,
                    savedPatient2
            );

            Appointment appointment6 = new Appointment(
                    LocalDate.of(2013, 9, 15),
                    LocalTime.of(18, 0),
                    savedSurgery3,
                    savedDentist3,
                    savedPatient4
            );


            appointmentService.addAppointment(appointment);
            appointmentService.addAppointment(appointment2);
            appointmentService.addAppointment(appointment3);
            appointmentService.addAppointment(appointment4);
            appointmentService.addAppointment(appointment5);
            appointmentService.addAppointment(appointment6);

            System.out.println(appointmentService.getAllAppointments());
        };
    }
}