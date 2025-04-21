package miu.edu.cs.cs489.finalexam.service.impl;

import miu.edu.cs.cs489.finalexam.dto.request.SatelliteRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.SatelliteResponseDto;
import miu.edu.cs.cs489.finalexam.exception.SatelliteNotFoundException;
import miu.edu.cs.cs489.finalexam.mapper.SatelliteMapper;
import miu.edu.cs.cs489.finalexam.model.Satellite;
import miu.edu.cs.cs489.finalexam.repository.SatelliteRepository;
import miu.edu.cs.cs489.finalexam.service.SatelliteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SatelliteServiceImpl implements SatelliteService {
    @Autowired
    SatelliteRepository satelliteRepository;

    @Autowired
    SatelliteMapper satelliteMapper;

    @Override
    public Optional<SatelliteResponseDto> updateSatellite(SatelliteRequestDto satelliteRequestDto, Long satelliteId) throws SatelliteNotFoundException {
        Optional<Satellite> optionalSatellite = satelliteRepository.findById(satelliteId);

        if (optionalSatellite.isPresent()) {
            Satellite satelliteToUpdate = satelliteMapper.satelliteRequestDtoToSatellite(satelliteRequestDto);

            satelliteToUpdate.setId(optionalSatellite.get().getId());

            Satellite savedSatellite =  satelliteRepository.save(satelliteToUpdate);

            SatelliteResponseDto satelliteResponseDto = satelliteMapper.satelliteTosatelliteResponseDto(savedSatellite);

            return Optional.ofNullable(satelliteResponseDto);
        }
        else {
            throw new SatelliteNotFoundException("Satellite with id " + satelliteId + " not found");
        }
    }

    public Optional<SatelliteResponseDto> getSatelliteById(Long satelliteId) throws SatelliteNotFoundException {
        Optional<Satellite> optionalSatellite = satelliteRepository.findById(satelliteId);

        if (optionalSatellite.isPresent()) {
            return Optional.ofNullable(satelliteMapper.satelliteTosatelliteResponseDto(optionalSatellite.get()));
        }

        throw new SatelliteNotFoundException("Satellite with id " + satelliteId + " not found");
    }
}
