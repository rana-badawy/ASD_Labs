package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getAllPatients();

    Optional<Patient> getPatientById(Integer patientId);

    Optional<Patient> addPatient(Patient patient);

    Optional<Patient> updatePatient(Patient patient);

    void deletePatientById(Integer patientId);
}
