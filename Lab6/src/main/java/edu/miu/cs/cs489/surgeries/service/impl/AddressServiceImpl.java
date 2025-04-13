package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.model.Address;
import edu.miu.cs.cs489.surgeries.repository.AddressRepository;
import edu.miu.cs.cs489.surgeries.service.AddressService;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<Address> getAddressById(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isPresent()) {
            return Optional.ofNullable(address.get());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Address> addAddress(Address address) {
        Address savedAddress = addressRepository.save(address);

        return Optional.ofNullable(savedAddress);
    }

    @Override
    public Optional<Address> updateAddress(Address address) {
        Address savedAddress = addressRepository.save(address);

        return Optional.ofNullable(savedAddress);
    }

    @Override
    public void deleteAddressById(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isPresent()) {
            addressRepository.deleteById(addressId);
        }
    }
}
