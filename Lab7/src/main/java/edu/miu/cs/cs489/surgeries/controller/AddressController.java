package edu.miu.cs.cs489.surgeries.controller;

import edu.miu.cs.cs489.surgeries.dto.response.AddressResponseDto2;
import edu.miu.cs.cs489.surgeries.service.AddressService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponseDto2>> getAllAddressesWithPatients() {
        List<AddressResponseDto2> addresses = addressService.getAllAddressesWithPatients();

        return ResponseEntity.status(HttpStatus.OK).body(addresses);
    }
}
