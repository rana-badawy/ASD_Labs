package edu.miu.cs.cs489.surgeries.service;

import edu.miu.cs.cs489.surgeries.model.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> getAddressById(Integer addressId);

    Optional<Address> addAddress(Address address);

    Optional<Address> updateAddress(Address address);

    void deleteAddressById(Integer addressId);
}
