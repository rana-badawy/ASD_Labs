package edu.miu.cs.cs489.surgeries.mapper;

import edu.miu.cs.cs489.surgeries.dto.request.AddressRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.AddressResponseDto;
import edu.miu.cs.cs489.surgeries.dto.response.AddressResponseDto2;
import edu.miu.cs.cs489.surgeries.model.Address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto);

    AddressResponseDto addressToAddressResponseDto(Address address);

    Address addressResponseDtoToAddress(AddressResponseDto addressResponseDto);

    @Mapping(source = "patient", target = "patientResponseDto2")
    AddressResponseDto2 addressToAddressResponseDto2(Address address);

    @Mapping(source = "patient", target = "patientResponseDto2")
    List<AddressResponseDto2> addressToAddressResponseDto2List(List<Address> addresses);
}
