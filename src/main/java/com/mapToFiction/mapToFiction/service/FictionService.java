package com.mapToFiction.mapToFiction.service;
import com.mapToFiction.mapToFiction.model.Fiction;
import java.util.List;

public interface FictionService {
    Fiction create(Fiction fiction);
    Fiction update(Fiction fiction);
    void delete(Long id);
    List<Fiction> getAll();
    Fiction getById(Long id);
}
