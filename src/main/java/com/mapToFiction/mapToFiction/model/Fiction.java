package com.mapToFiction.mapToFiction.model;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fictions")
public class Fiction {

    public enum Type {
        MOVIE, TV_SHOW, BOOK, SONG
    }
    public enum Provider {
        OMDB_API, TVDB_API, CUSTOM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "fiction")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Scene> scenes = new ArrayList<>();

    public Fiction() {}

    public Fiction(JsonNode fictionJsonNode) {
        this.name = fictionJsonNode.get("name").asText();
        this.type = Type.valueOf(fictionJsonNode.get("type").asText());
        JsonNode sceneNode = fictionJsonNode.get("scene");

        if (sceneNode != null) {
            Scene scene = new Scene(sceneNode);
            scene.setFiction(this);
            this.scenes.add(scene);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }
}
