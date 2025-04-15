package edu.miu.cs.cs489.surgeries.dto.response;

public record AddressResponseDto2(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode,
        PatientResponseDto2 patientResponseDto2
) {
}
