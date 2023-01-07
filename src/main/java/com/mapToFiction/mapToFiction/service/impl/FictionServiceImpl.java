package com.mapToFiction.mapToFiction.service.impl;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.repository.FictionRepository;
import com.mapToFiction.mapToFiction.service.FictionService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FictionServiceImpl implements FictionService {
    private final FictionRepository fictionRepository;

    public FictionServiceImpl(FictionRepository fictionRepository) {
        this.fictionRepository = fictionRepository;
    }

    @Override
    public List<Fiction> getAll() {
        return fictionRepository.findAll();
    }

    @Override
    public Fiction getById(Long id) {
        return fictionRepository.findById(id).orElse(null);
    }

    @Override
    public Fiction create(Fiction fiction) {
        return fictionRepository.save(fiction);
    }

    @Override
    public Fiction update(Fiction fiction) {
        return fictionRepository.save(fiction);
    }

    @Override
    public void delete(Long id) {
        fictionRepository.deleteById(id);
    }
}