package edu.miu.cs.cs489.surgeries.service.impl;

import edu.miu.cs.cs489.surgeries.dto.request.SurgeryRequestDto;
import edu.miu.cs.cs489.surgeries.dto.response.SurgeryResponseDto;
import edu.miu.cs.cs489.surgeries.mapper.SurgeryMapper;
import edu.miu.cs.cs489.surgeries.model.Surgery;
import edu.miu.cs.cs489.surgeries.repository.SurgeryRepository;
import edu.miu.cs.cs489.surgeries.service.SurgeryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;

    @Autowired
    private SurgeryMapper surgeryMapper;

    @Override
    public List<SurgeryResponseDto> getAllSurgeries() {
        return surgeryMapper.surgeriesToSurgeryResponseDtoList(surgeryRepository.findAll());
    }

    @Override
    public Optional<SurgeryResponseDto> addSurgery(SurgeryRequestDto surgeryRequestDto) {
        Surgery surgery = surgeryMapper.surgeryRequestDtoToSurgery(surgeryRequestDto);

        Surgery savedSurgery = surgeryRepository.save(surgery);

        SurgeryResponseDto surgeryResponseDto = surgeryMapper.surgeryToSurgeryResponseDto(savedSurgery);

        return Optional.ofNullable(surgeryResponseDto);
    }

    @Override
    public Optional<SurgeryResponseDto> getSurgeryById(Integer surgeryId) {
        Optional<Surgery> surgery = surgeryRepository.findById(surgeryId);

        if (surgery.isPresent()) {
            return Optional.ofNullable(surgeryMapper.surgeryToSurgeryResponseDto(surgery.get()));
        }

        return Optional.empty();
    }

    @Override
    public Optional<SurgeryResponseDto> updateSurgery(SurgeryRequestDto surgeryRequestDto) {
        Surgery surgery = surgeryMapper.surgeryRequestDtoToSurgery(surgeryRequestDto);

        Surgery savedSurgery = surgeryRepository.save(surgery);

        SurgeryResponseDto surgeryResponseDto = surgeryMapper.surgeryToSurgeryResponseDto(savedSurgery);

        return Optional.ofNullable(surgeryResponseDto);
    }

    @Override
    public void deleteSurgeryById(Integer surgeryId) {
        Optional<Surgery> surgery = surgeryRepository.findById(surgeryId);

        if (surgery.isPresent())
            surgeryRepository.deleteById(surgeryId);
    }
}
