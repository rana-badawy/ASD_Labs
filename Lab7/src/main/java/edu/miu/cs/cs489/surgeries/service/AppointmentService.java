package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.AppointmentResponseDto;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<AppointmentResponseDto> getAllAppointments();

    Optional<AppointmentResponseDto> getAppointmentById(Integer appointmentId);

    List<AppointmentResponseDto> getAppointmentsByPatientId(Integer patientId);

    Optional<AppointmentResponseDto> addAppointment(AppointmentRequestDto appointmentRequestDto);

    Optional<AppointmentResponseDto> updateAppointment(AppointmentRequestDto appointmentRequestDto);

    void deleteAppointmentById(Integer appointmentId);
}
