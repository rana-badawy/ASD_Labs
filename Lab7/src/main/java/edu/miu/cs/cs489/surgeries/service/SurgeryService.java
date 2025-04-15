package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.dto.request.SurgeryRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.SurgeryResponseDto;

import java.util.List;
import java.util.Optional;

public interface SurgeryService {

    List<SurgeryResponseDto> getAllSurgeries();

    Optional<SurgeryResponseDto> getSurgeryById(Integer surgeryId);

    Optional<SurgeryResponseDto> addSurgery(SurgeryRequestDto surgeryRequestDto);

    Optional<SurgeryResponseDto> updateSurgery(SurgeryRequestDto surgeryRequestDto);

    void deleteSurgeryById(Integer surgeryId);

}
