package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.model.Patient;
import edu.miu.cs.cs489.surgeries.repository.PatientRepository;
import edu.miu.cs.cs489.surgeries.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Integer patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            return Optional.of(patient.get());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Patient> addPatient(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);

        return Optional.of(savedPatient);
    }

    @Override
    public Optional<Patient> updatePatient(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);

        return Optional.of(savedPatient);
    }

    @Override
    public void deletePatientById(Integer patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            patientRepository.delete(patient.get());
        }
    }
}
