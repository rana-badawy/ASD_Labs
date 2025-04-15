package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.dto.request.DentistRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.DentistResponseDto;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    List<DentistResponseDto> getAllDentists();

    Optional<DentistResponseDto> getDentistById(Integer dentistId);

    Optional<DentistResponseDto> addDentist(DentistRequestDto dentistRequestDto);

    Optional<DentistResponseDto> updateDentist(DentistRequestDto dentistRequestDto);

    void deleteDentistById(Integer dentistId);
}
