package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.dto.request.AddressRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.AddressResponseDto;
import edu.miu.cs.cs489.surgeries.dto.response.AddressResponseDto2;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<AddressResponseDto> getAddressById(Integer addressId);

    Optional<AddressResponseDto> addAddress(AddressRequestDto addressRequestDto);

    void deleteAddressById(Integer addressId);

    List<AddressResponseDto2> getAllAddressesWithPatients();
}
