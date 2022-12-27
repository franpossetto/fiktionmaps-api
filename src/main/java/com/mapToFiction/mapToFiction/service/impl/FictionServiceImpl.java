package com.mapToFiction.mapToFiction.service.impl;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.repository.FictionRepository;
import com.mapToFiction.mapToFiction.service.FictionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FictionServiceImpl implements FictionService {
    private final FictionRepository fictionRepository;

    public FictionServiceImpl(FictionRepository fictionRepository) {
        this.fictionRepository = fictionRepository;
    }

    @Override
    public List<Fiction> getAllFictions() {
        return fictionRepository.findAll();
    }

    @Override
    public Fiction getFictionById(String id) {
        return fictionRepository.findById(id).orElse(null);
    }

    @Override
    public Fiction createFiction(Fiction fiction) {
        return fictionRepository.save(fiction);
    }

    @Override
    public Fiction updateFiction(Fiction fiction) {
        return fictionRepository.save(fiction);
    }

    @Override
    public void deleteFiction(String id) {
        fictionRepository.deleteById(id);
    }
}