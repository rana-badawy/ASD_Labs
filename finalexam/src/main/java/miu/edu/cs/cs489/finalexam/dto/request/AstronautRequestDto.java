package miu.edu.cs.cs489.finalexam.dto.request;

import java.util.List;

public record AstronautRequestDto(
        String firstName,
        String lastName,
        Integer experienceYears,
        List<Long> satelliteIds
) {
}
