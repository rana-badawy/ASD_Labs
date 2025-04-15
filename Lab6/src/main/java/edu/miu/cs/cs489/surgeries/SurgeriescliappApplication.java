package edu.miu.cs.cs489.surgeries;

import edu.miu.cs.cs489.surgeries.model.*;
import edu.miu.cs.cs489.surgeries.service.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    CommandLineRunner commandLineRunner() {
        return args -> {
            Address address1 = new Address(
                    "S1",
                    "Fairfield",
                    "Iowa",
                    "65584"
            );

            Address address2 = new Address(
                    "S2",
                    "Fairfield",
                    "Iowa",
                    "65584"
            );

            Address address3 = new Address(
                    "S3",
                    "Des Moines",
                    "Iowa",
                    "82359"
            );

            Address address4 = new Address(
                    "S4",
                    "Des Moines",
                    "Iowa",
                    "84469"
            );

            Address address5 = new Address(
                    "S5",
                    "Irving",
                    "Texas",
                    "75063"
            );

            Address address6 = new Address(
                    "S6",
                    "Irving",
                    "Texas",
                    "75063"
            );

            Address address7 = new Address(
                    "S7",
                    "Plano",
                    "Texas",
                    "84495"
            );

            Address address8 = new Address(
                    "S8",
                    "Plano",
                    "Texas",
                    "25164"
            );

            Address savedAddress1 = addressService.addAddress(address1).get();
            Address savedAddress2 = addressService.addAddress(address2).get();
            Address savedAddress3 = addressService.addAddress(address3).get();
            Address savedAddress4 = addressService.addAddress(address4).get();
            Address savedAddress5 = addressService.addAddress(address5).get();
            Address savedAddress6 = addressService.addAddress(address6).get();
            Address savedAddress7 = addressService.addAddress(address7).get();
            Address savedAddress8 = addressService.addAddress(address8).get();

            Surgery surgery1 = new Surgery(
                    "S15",
                    "1234567898",
                    savedAddress1);

            Surgery surgery2 = new Surgery(
                    "S10",
                    "1254896325",
                    savedAddress2);

            Surgery surgery3 = new Surgery(
                    "S13",
                    "5846932158",
                    savedAddress8);


            Dentist dentist1 = new Dentist(
                    "Tony",
                    "Smith",
                    "tony@gmail.com",
                    "1515474151",
                    "sp1"
            );

            Dentist dentist2 = new Dentist(
                    "Helen",
                    "Pearson",
                    "helen@gmail.com",
                    "1515474151",
                    "sp2"
            );

            Dentist dentist3 = new Dentist(
                    "Robin",
                    "Plevin",
                    "robin@gmail.com",
                    "1515474151",
                    "sp3"
            );


            Patient patient1 = new Patient(
                    "Gillian",
                    "White",
                    "gillian@gmail.com",
                    "1515474151",
                    LocalDate.of(1997, 5, 14),
                    savedAddress3
            );

            Patient patient2 = new Patient(
                    "Jill",
                    "Bell",
                    "jill@gmail.com",
                    "1515474151",
                    LocalDate.of(1999, 6, 8),
                    savedAddress4
            );

            Patient patient3 = new Patient(
                    "Ian",
                    "McKay",
                    "ian@gmail.com",
                    "1515474151",
                    LocalDate.of(1990, 9, 1),
                    savedAddress6
            );

            Patient patient4 = new Patient(
                    "John",
                    "Walker",
                    "joh@gmail.com",
                    "1515474151",
                    LocalDate.of(2000, 7, 5),
                    savedAddress7
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