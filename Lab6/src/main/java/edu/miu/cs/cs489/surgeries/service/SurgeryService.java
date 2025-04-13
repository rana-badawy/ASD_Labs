package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.model.Surgery;

import java.util.List;
import java.util.Optional;

public interface SurgeryService {

    List<Surgery> getAllSurgeries();

    Optional<Surgery> getSurgeryById(Integer surgeryId);

    Optional<Surgery> addSurgery(Surgery surgery);

    Optional<Surgery> updateSurgery(Surgery surgery);

    void deleteSurgeryById(Integer surgeryId);

}
