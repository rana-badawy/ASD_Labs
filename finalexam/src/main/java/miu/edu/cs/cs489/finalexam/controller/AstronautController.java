package miu.edu.cs.cs489.finalexam.controller;

import miu.edu.cs.cs489.finalexam.dto.request.AstronautRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.AstronautResponseDto;
import miu.edu.cs.cs489.finalexam.service.AstronautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/astronauts")
public class AstronautController {

    @Autowired
    private AstronautService astronautService;

    @PostMapping
    public ResponseEntity<AstronautResponseDto> addAstronaut(@Valid @RequestBody AstronautRequestDto astronautRequestDto) {
        Optional<AstronautResponseDto> savedAstronaut = astronautService.addAstronaut(astronautRequestDto);
        return new ResponseEntity<>(savedAstronaut.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponseDto>> getAllAstronauts(
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order
    ) {
        List<AstronautResponseDto> astronauts = astronautService.findAllSorted(sort, order);
        return new ResponseEntity<>(astronauts, HttpStatus.OK);
    }
}
