package com.mapToFiction.mapToFiction.model.dto.gmaps;

import java.util.ArrayList;

public class RootDTO {
    public ArrayList<ResultsDTO> results;
    public String status;

    public ArrayList<ResultsDTO> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultsDTO> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
