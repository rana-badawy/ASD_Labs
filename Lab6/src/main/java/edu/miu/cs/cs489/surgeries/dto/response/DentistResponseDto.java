package edu.miu.cs.cs489.surgeries.dto.response;

public record DentistResponseDto(
        Integer dentistId,
        String firstName,
        String lastName,
        String email,
        String phone,
        String specialization
) {
}
