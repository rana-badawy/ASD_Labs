package edu.miu.cs.cs489.surgeries.dto.request;

public record UserRequestDto(
        String userName,
        String password,
        RoleRequestDto roleRequestDto
) {
}
