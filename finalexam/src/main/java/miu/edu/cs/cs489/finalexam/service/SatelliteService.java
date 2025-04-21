package miu.edu.cs.cs489.finalexam.service;

import miu.edu.cs.cs489.finalexam.dto.request.SatelliteRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.SatelliteResponseDto;
import miu.edu.cs.cs489.finalexam.exception.SatelliteNotFoundException;

import java.util.Optional;

public interface SatelliteService {
    Optional<SatelliteResponseDto> updateSatellite(SatelliteRequestDto satelliteRequestDto, Long satelliteId);

    Optional<SatelliteResponseDto> getSatelliteById(Long satelliteId) throws SatelliteNotFoundException;
}
