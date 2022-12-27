package com.mapToFiction.mapToFiction.service;
import com.mapToFiction.mapToFiction.model.Fiction;
import java.util.List;

public interface FictionService {
    Fiction createFiction(Fiction fiction);
    Fiction updateFiction(Fiction fiction);
    void deleteFiction(String id);

    List<Fiction> getAllFictions();
    Fiction getFictionById(String id);
}
