package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.dto.request.AddressRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.AddressResponseDto;
import edu.miu.cs.cs489.surgeries.dto.response.AddressResponseDto2;
import edu.miu.cs.cs489.surgeries.mapper.AddressMapper;
import edu.miu.cs.cs489.surgeries.model.Address;
import edu.miu.cs.cs489.surgeries.repository.AddressRepository;
import edu.miu.cs.cs489.surgeries.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Optional<AddressResponseDto> getAddressById(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isPresent()) {
            return Optional.ofNullable(addressMapper.addressToAddressResponseDto(address.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<AddressResponseDto> addAddress(AddressRequestDto addressRequestDto) {
        Address address = addressMapper.addressRequestDtoToAddress(addressRequestDto);

        Address savedAddress = addressRepository.save(address);

        AddressResponseDto addressResponseDto = addressMapper.addressToAddressResponseDto(savedAddress);

        return Optional.ofNullable(addressResponseDto);
    }

    @Override
    public void deleteAddressById(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isPresent()) {
            addressRepository.deleteById(addressId);
        }
    }

    @Override
    public List<AddressResponseDto2> getAllAddressesWithPatients() {
        return addressMapper.addressToAddressResponseDto2List(addressRepository.getAllAddressesWithPatients());
    }
}
