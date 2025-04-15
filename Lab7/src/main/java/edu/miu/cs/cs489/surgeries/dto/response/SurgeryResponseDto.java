package edu.miu.cs.cs489.surgeries.dto.response;

public record SurgeryResponseDto(
        Integer surgeryId,
        String name,
        String phone,
        AddressResponseDto addressResponseDto
) {
}
