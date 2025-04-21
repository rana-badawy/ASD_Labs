package miu.edu.cs.cs489.finalexam.dto.response;

import java.time.LocalDate;

public record SatelliteResponseDto(
        Long id,
        String name,
        LocalDate launchDate,
        String orbitType,
        boolean decommissioned
) {
}
