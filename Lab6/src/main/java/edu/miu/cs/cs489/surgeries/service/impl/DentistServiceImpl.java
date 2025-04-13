package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.model.Dentist;
import edu.miu.cs.cs489.surgeries.repository.DentistRepository;
import edu.miu.cs.cs489.surgeries.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Optional<Dentist> getDentistById(Integer dentistId) {
        Optional<Dentist> dentist = dentistRepository.findById(dentistId);

        if (dentist.isPresent()) {
            return Optional.of(dentist.get());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Dentist> addDentist(Dentist dentist) {
        Dentist savedDentist = dentistRepository.save(dentist);

        return Optional.ofNullable(savedDentist);
    }

    @Override
    public Optional<Dentist> updateDentist(Dentist dentist) {
        Dentist savedDentist = dentistRepository.save(dentist);

        return Optional.ofNullable(savedDentist);
    }

    @Override
    public void deleteDentistById(Integer dentistId) {
        Optional<Dentist> dentist = dentistRepository.findById(dentistId);

        if (dentist.isPresent())
            dentistRepository.delete(dentist.get());
    }
}
