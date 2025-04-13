package edu.miu.cs.cs489.surgeries.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="serguryId")
    private Surgery surgery;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dentistId")
    private Dentist dentist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patientId")
    private Patient patient;

    public Appointment() {}

    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, Surgery surgery, Dentist dentist, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.surgery = surgery;
        this.dentist = dentist;
        this.patient = patient;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", surgery=" + surgery +
                ", dentist=" + dentist +
                ", patient=" + patient +
                '}';
    }
}
