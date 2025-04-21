package miu.edu.cs.cs489.finalexam.service.impl;

import miu.edu.cs.cs489.finalexam.dto.request.AstronautRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.AstronautResponseDto;
import miu.edu.cs.cs489.finalexam.dto.response.SatelliteResponseDto;
import miu.edu.cs.cs489.finalexam.mapper.AstronautMapper;
import miu.edu.cs.cs489.finalexam.mapper.SatelliteMapper;
import miu.edu.cs.cs489.finalexam.model.Astronaut;
import miu.edu.cs.cs489.finalexam.model.Satellite;
import miu.edu.cs.cs489.finalexam.repository.AstronautRepository;
import miu.edu.cs.cs489.finalexam.repository.SatelliteRepository;
import miu.edu.cs.cs489.finalexam.service.AstronautService;
import miu.edu.cs.cs489.finalexam.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AstronautServiceImpl implements AstronautService {
    @Autowired
    private AstronautRepository astronautRepository;

    @Autowired
    private SatelliteRepository satelliteRepository;

    @Autowired
    private AstronautMapper astronautMapper;

    @Override
    public List<AstronautResponseDto> findAllSorted(String sortBy, String order) {
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, sortBy);

        List<Astronaut> astronauts = astronautRepository.findAll(sort)
                .stream()
                .toList();

        return astronautMapper.astronautsToAstronautResponseDtos(astronauts);
    }

    @Override
    public Optional<AstronautResponseDto> addAstronaut(AstronautRequestDto astronautRequestDto) {
        Astronaut astronaut = astronautMapper.astronautRequestDtoToAstronaut(astronautRequestDto);

        if (astronautRequestDto.satelliteIds() != null && !astronautRequestDto.satelliteIds().isEmpty()) {
            List<Satellite> satellites = new ArrayList<>();

            for (Long id : astronautRequestDto.satelliteIds()) {

                Optional<Satellite> satellite = satelliteRepository.findById(id);
                satellites.add(satellite.get());
            }
            astronaut.setSatellites(satellites);
        }
        Astronaut savedAstronaut =  astronautRepository.save(astronaut);

        AstronautResponseDto astronautResponseDto = astronautMapper.astronautToAstronautResponseDto(savedAstronaut);

        return Optional.ofNullable(astronautResponseDto);
    }
}
