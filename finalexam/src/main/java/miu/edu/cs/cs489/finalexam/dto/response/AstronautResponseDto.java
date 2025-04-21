package miu.edu.cs.cs489.finalexam.dto.response;

import java.util.List;

public record AstronautResponseDto(
        Long id,
        String firstName,
        String lastName,
        Integer experienceYears,
        List<SatelliteResponseDto> satelliteResponseDtos
) {
}
