package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.model.Appointment;
import edu.miu.cs.cs489.surgeries.model.Patient;
import edu.miu.cs.cs489.surgeries.repository.AppointmentRepository;
import edu.miu.cs.cs489.surgeries.repository.PatientRepository;
import edu.miu.cs.cs489.surgeries.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Integer appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);

        if (appointment.isPresent()) {
            return Optional.of(appointment.get());
        }
        return Optional.empty();
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Integer patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            return appointmentRepository.findByPatient(patient.get());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<Appointment> addAppointment(Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);

        return Optional.of(savedAppointment);
    }

    @Override
    public Optional<Appointment> updateAppointment(Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);

        return Optional.of(savedAppointment);
    }

    @Override
    public void deleteAppointmentById(Integer appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);

        if (appointment.isPresent()) {
            appointmentRepository.delete(appointment.get());
        }
    }
}
