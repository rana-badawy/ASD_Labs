package miu.edu.cs.cs489.finalexam.controller;

import jakarta.validation.Valid;
import miu.edu.cs.cs489.finalexam.dto.request.SatelliteRequestDto;
import miu.edu.cs.cs489.finalexam.dto.response.SatelliteResponseDto;
import miu.edu.cs.cs489.finalexam.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/satellites")
public class SatelliteController {
    @Autowired
    SatelliteService satelliteService;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSatellite(@Valid @RequestBody SatelliteRequestDto satelliteRequestDto,
                                             @PathVariable Long id) {
        Optional<SatelliteResponseDto> satelliteResponseDto = satelliteService.updateSatellite(satelliteRequestDto, id);

        return new ResponseEntity<SatelliteResponseDto>(satelliteResponseDto.get(), HttpStatus.OK);
    }
}
