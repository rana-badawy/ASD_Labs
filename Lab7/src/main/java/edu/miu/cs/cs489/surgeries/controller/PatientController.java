package edu.miu.cs.cs489.surgeries.controller;

import edu.miu.cs.cs489.surgeries.dto.request.PatientRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.PatientResponseDto;
import edu.miu.cs.cs489.surgeries.exception.DuplicatePatientException;
import edu.miu.cs.cs489.surgeries.exception.PatientNotFoundException;
import edu.miu.cs.cs489.surgeries.service.PatientService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatientsSortedByLastName() {
        List<PatientResponseDto> patients = patientService.getAllPatientsSortedByLastName();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Integer patientId) {
        return ResponseEntity.ok(patientService.getPatientById(patientId).get());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> addPatient(@Valid @RequestBody PatientRequestDto patientRequestDto) {
        return new ResponseEntity<>(patientService.addPatient(patientRequestDto).get(), HttpStatus.CREATED);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponseDto> updatePatient(@Valid @RequestBody PatientRequestDto patientRequestDto,
                                                            @PathVariable Integer patientId) {
        return ResponseEntity.ok(patientService.updatePatient(patientRequestDto, patientId).get());
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<?> deletePatientById(@PathVariable Integer patientId) {
        patientService.deletePatientById(patientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<PatientResponseDto>> getAllPatientsWithName(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.getAllPatientsWithName(searchString));
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handlePatientNotFound(PatientNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicatePatientException.class)
    public ResponseEntity<String> handleDupplicatePatientFound(DuplicatePatientException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
