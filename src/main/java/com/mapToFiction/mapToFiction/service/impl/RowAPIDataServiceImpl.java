package com.mapToFiction.mapToFiction.service.impl;

import com.mapToFiction.mapToFiction.model.RowAPIData;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.repository.RowAPIDataRepository;
import com.mapToFiction.mapToFiction.repository.SceneRepository;
import com.mapToFiction.mapToFiction.service.RowAPIDataService;
import org.springframework.stereotype.Service;

@Service
public class RowAPIDataServiceImpl implements RowAPIDataService {

    private final RowAPIDataRepository rowAPIDataRepository;

    RowAPIDataServiceImpl(RowAPIDataRepository rowAPIDataRepository) {
        this.rowAPIDataRepository = rowAPIDataRepository;
    }
    @Override
    public RowAPIData create(RowAPIData rowData) {
        return rowAPIDataRepository.save(rowData);
    }
}
