package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.dto.request.PatientRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.PatientResponseDto;
import edu.miu.cs.cs489.surgeries.exception.DuplicatePatientException;
import edu.miu.cs.cs489.surgeries.exception.PatientNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientResponseDto> getAllPatients();

    List<PatientResponseDto> getAllPatientsSortedByLastName();

    List<PatientResponseDto> getAllPatientsWithName(String name);

    Optional<PatientResponseDto> getPatientById(Integer patientId) throws PatientNotFoundException;

    Optional<PatientResponseDto> addPatient(PatientRequestDto patientRequestDto) throws DuplicatePatientException;

    Optional<PatientResponseDto> updatePatient(PatientRequestDto patientRequestDto, Integer patientId) throws PatientNotFoundException;

    void deletePatientById(Integer patientId);
}
