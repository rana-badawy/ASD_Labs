package miu.edu.cs.cs489.finalexam.mapper;

import miu.edu.cs.cs489.finalexam.dto.request.AstronautRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.AstronautResponseDto;
import miu.edu.cs.cs489.finalexam.model.Astronaut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SatelliteMapper.class})
public interface AstronautMapper {
    Astronaut astronautRequestDtoToAstronaut(AstronautRequestDto astronautRequestDto);

    @Mapping(source = "satellites", target = "satelliteResponseDtos")
    AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);

    @Mapping(source = "satellites", target = "satelliteResponseDtos")
    List<AstronautResponseDto> astronautsToAstronautResponseDtos(List<Astronaut> astronauts);
}
