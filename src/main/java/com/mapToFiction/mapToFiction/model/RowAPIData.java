package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
@Entity
public class RowAPIData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String key;

    @Type(type = "text")
    private String gmaps;

    @Type(type = "text")
    private String tmdb;

    public RowAPIData(JsonNode rowAPIDataJsonNode){
        this.key = rowAPIDataJsonNode.get("key").asText();
        this.gmaps = rowAPIDataJsonNode.get("gmaps").asText();
        this.tmdb = rowAPIDataJsonNode.get("tmdb").asText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getGmaps() {
        return gmaps;
    }

    public void setGmaps(String gmaps) {
        this.gmaps = gmaps;
    }

    public String getTmdb() {
        return tmdb;
    }

    public void setTmdb(String tmdb) {
        this.tmdb = tmdb;
    }
}
