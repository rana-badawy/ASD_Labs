package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    Optional<Appointment> getAppointmentById(Integer appointmentId);

    List<Appointment> getAppointmentsByPatientId(Integer patientId);

    Optional<Appointment> addAppointment(Appointment appointment);

    Optional<Appointment> updateAppointment(Appointment appointment);

    void deleteAppointmentById(Integer appointmentId);
}
