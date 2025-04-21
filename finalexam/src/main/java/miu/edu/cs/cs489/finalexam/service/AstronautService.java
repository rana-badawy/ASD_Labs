package miu.edu.cs.cs489.finalexam.service;

import miu.edu.cs.cs489.finalexam.dto.request.AstronautRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.AstronautResponseDto;

import java.util.List;
import java.util.Optional;

public interface AstronautService {
    List<AstronautResponseDto> findAllSorted(String sortBy, String order);

    Optional<AstronautResponseDto> addAstronaut(AstronautRequestDto astronautRequestDto);
}
