package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.AppointmentResponseDto;
import edu.miu.cs.cs489.surgeries.mapper.AppointmentMapper;
import edu.miu.cs.cs489.surgeries.model.Appointment;
import edu.miu.cs.cs489.surgeries.model.Patient;
import edu.miu.cs.cs489.surgeries.repository.AppointmentRepository;
import edu.miu.cs.cs489.surgeries.repository.DentistRepository;
import edu.miu.cs.cs489.surgeries.repository.PatientRepository;
import edu.miu.cs.cs489.surgeries.repository.SurgeryRepository;
import edu.miu.cs.cs489.surgeries.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        return appointmentMapper.appointmentsToAppointmentResponseDtoList(appointmentRepository.findAll());
    }

    @Override
    public Optional<AppointmentResponseDto> getAppointmentById(Integer appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);

        if (appointment.isPresent()) {
            return Optional.of(appointmentMapper.appointmentToAppointmentResponseDto(appointment.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<AppointmentResponseDto> getAppointmentsByPatientId(Integer patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            return appointmentMapper.appointmentsToAppointmentResponseDtoList(appointmentRepository.findByPatient(patient.get()));
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<AppointmentResponseDto> addAppointment(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = appointmentMapper.appointmentRequestDtoToAppointment(appointmentRequestDto);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentResponseDto appointmentResponseDto = appointmentMapper.appointmentToAppointmentResponseDto(savedAppointment);

        return Optional.of(appointmentResponseDto);
    }

    @Override
    public Optional<AppointmentResponseDto> updateAppointment(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = appointmentMapper.appointmentRequestDtoToAppointment(appointmentRequestDto);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentResponseDto appointmentResponseDto = appointmentMapper.appointmentToAppointmentResponseDto(savedAppointment);

        return Optional.of(appointmentResponseDto);
    }

    @Override
    public void deleteAppointmentById(Integer appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);

        if (appointment.isPresent()) {
            appointmentRepository.delete(appointment.get());
        }
    }
}
