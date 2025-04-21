package miu.edu.cs.cs489.finalexam.mapper;

import miu.edu.cs.cs489.finalexam.dto.request.SatelliteRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.SatelliteResponseDto;
import miu.edu.cs.cs489.finalexam.model.Satellite;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SatelliteMapper {
    Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto satelliteRequestDto);

    SatelliteResponseDto satelliteTosatelliteResponseDto(Satellite satellite);
}
