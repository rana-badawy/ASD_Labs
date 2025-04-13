package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.model.Surgery;
import edu.miu.cs.cs489.surgeries.repository.SurgeryRepository;
import edu.miu.cs.cs489.surgeries.service.SurgeryService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Optional<Surgery> addSurgery(Surgery surgery) {
        Surgery savedSurgery = surgeryRepository.save(surgery);

        return Optional.ofNullable(savedSurgery);
    }

    @Override
    public Optional<Surgery> getSurgeryById(Integer surgeryId) {
        Optional<Surgery> surgery = surgeryRepository.findById(surgeryId);

        if (surgery.isPresent()) {
            return Optional.ofNullable(surgery.get());
        }

        return Optional.empty();
    }

    @Override
    public Optional<Surgery> updateSurgery(Surgery surgery) {
        Surgery savedSurgery = surgeryRepository.save(surgery);

        return Optional.ofNullable(savedSurgery);
    }

    @Override
    public void deleteSurgeryById(Integer surgeryId) {
        Optional<Surgery> surgery = surgeryRepository.findById(surgeryId);

        if (surgery.isPresent())
            surgeryRepository.deleteById(surgeryId);
    }
}
