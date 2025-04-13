package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    List<Dentist> getAllDentists();

    Optional<Dentist> getDentistById(Integer dentistId);

    Optional<Dentist> addDentist(Dentist dentist);

    Optional<Dentist> updateDentist(Dentist dentist);

    void deleteDentistById(Integer dentistId);
}
