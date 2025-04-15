package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.dto.request.DentistRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.DentistResponseDto;
import edu.miu.cs.cs489.surgeries.mapper.DentistMapper;
import edu.miu.cs.cs489.surgeries.model.Dentist;
import edu.miu.cs.cs489.surgeries.repository.DentistRepository;
import edu.miu.cs.cs489.surgeries.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {
    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private DentistMapper dentistMapper;

    @Override
    public List<DentistResponseDto> getAllDentists() {
        return dentistMapper.dentistsToDentistResponseDtoList(dentistRepository.findAll());
    }

    @Override
    public Optional<DentistResponseDto> getDentistById(Integer dentistId) {
        Optional<Dentist> dentist = dentistRepository.findById(dentistId);

        if (dentist.isPresent()) {
            return Optional.of(dentistMapper.dentistToDentistResponseDto(dentist.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<DentistResponseDto> addDentist(DentistRequestDto dentistRequestDto) {
        Dentist dentist = dentistMapper.dentistRequestDtoToDentist(dentistRequestDto);

        Dentist savedDentist = dentistRepository.save(dentist);

        DentistResponseDto dentistResponseDto = dentistMapper.dentistToDentistResponseDto(savedDentist);

        return Optional.ofNullable(dentistResponseDto);
    }

    @Override
    public Optional<DentistResponseDto> updateDentist(DentistRequestDto dentistRequestDto) {
        Dentist dentist = dentistMapper.dentistRequestDtoToDentist(dentistRequestDto);

        Dentist savedDentist = dentistRepository.save(dentist);

        DentistResponseDto dentistResponseDto = dentistMapper.dentistToDentistResponseDto(savedDentist);

        return Optional.ofNullable(dentistResponseDto);
    }

    @Override
    public void deleteDentistById(Integer dentistId) {
        Optional<Dentist> dentist = dentistRepository.findById(dentistId);

        if (dentist.isPresent())
            dentistRepository.delete(dentist.get());
    }
}
