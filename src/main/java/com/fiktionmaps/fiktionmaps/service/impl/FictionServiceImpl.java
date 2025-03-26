package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.dto.FictionByAreaRequestDTO;
import com.fiktionmaps.fiktionmaps.dto.FictionByAreaResponseDTO;
import com.fiktionmaps.fiktionmaps.mapper.FictionMapper;
import com.fiktionmaps.fiktionmaps.model.Fiction;
import com.fiktionmaps.fiktionmaps.repository.FictionRepository;
import com.fiktionmaps.fiktionmaps.service.FictionService;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FictionServiceImpl implements FictionService {

    private final FictionRepository fictionRepository;
    private final FictionMapper fictionMapper;

    public FictionServiceImpl(FictionRepository fictionRepository,
                            FictionMapper fictionMapper) {
        this.fictionRepository = fictionRepository;
        this.fictionMapper = fictionMapper;
    }

    @Override
    public FictionDTO create(FictionDTO fictionDto) {
        Fiction fiction = fictionMapper.toEntity(fictionDto);
        Fiction savedFiction = fictionRepository.save(fiction);
        return fictionMapper.toDto(savedFiction);
    }

    @Override
    public FictionDTO update(Long id, FictionDTO fictionDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        fictionRepository.deleteById(id);
    }

    @Override
    public List<FictionDTO> getAll() {
        List<Fiction> fictions = fictionRepository.findAll();
        return fictionMapper.toDtoList(fictions);
    }

    @Override
    public List<FictionDTO> getFictionsByCity(Long cityId) {
        List<Fiction> fictions = fictionRepository.findByCityId(cityId);
        return fictionMapper.toDtoList(fictions);
    }

    @Override
    public Fiction findById(Long id) {
        return fictionRepository.findById(id).get();
    }

    @Override
    public List<FictionByAreaResponseDTO> findByCoordinatesBetween(FictionByAreaRequestDTO request) {
        List<Fiction> fictions = fictionRepository.findByCoordinatesBetween(
            request.getLowerLat(),
            request.getUpperLat(),
            request.getLeftLng(),
            request.getRightLng()
        );

        return fictions.stream()
            .map(fiction -> new FictionByAreaResponseDTO(
                fiction.getId(),
                fiction.getName(),
                fiction.getType().toString(),
                fiction.getYear(),
                fiction.getDuration(),
                fiction.getImgUrl(),
                fiction.getPublished()
            ))
            .collect(Collectors.toList());
    }
}
