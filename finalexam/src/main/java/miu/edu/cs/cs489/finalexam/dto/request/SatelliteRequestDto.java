package miu.edu.cs.cs489.finalexam.dto.request;

import java.time.LocalDate;

public record SatelliteRequestDto(
        String name,
        LocalDate launchDate,
        String orbitType,
        boolean decommissioned
) {
}
