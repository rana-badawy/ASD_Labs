package edu.miu.cs.cs489.surgeries.dto.response;

import java.time.LocalDate;

public record PatientResponseDto2(
        Integer patientId,
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDate dob
) {
}
