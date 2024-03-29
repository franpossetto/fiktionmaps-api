package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fictions")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fiction {

    public enum Type {
        MOVIE, TV_SHOW, EPISODE, BOOK, SONG
    }

    public enum Provider {
        OMDB_API, TVDB_API, CUSTOM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fictionSeq")
    @SequenceGenerator(name = "fictionSeq", initialValue = 500, allocationSize = 1)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    private String externalId;

    private Integer year;
    private Integer duration;

    private String imgUrl;

    @OneToMany(mappedBy = "fiction", cascade = CascadeType.ALL)
    private List<Scene> scenes = new ArrayList<>();

    public Fiction(JsonNode fictionJsonNode) {
        this.name = String.valueOf(fictionJsonNode.get("name"));
        this.type = Type.valueOf(fictionJsonNode.get("type").asText());
        this.externalId = String.valueOf(fictionJsonNode.get("externalId").asText());
        this.duration = Integer.valueOf(fictionJsonNode.get("type").asInt());


        JsonNode sceneNode = fictionJsonNode.get("scene");
        if (sceneNode != null) {
            Scene scene = new Scene(sceneNode);
            scene.setFiction(this);
            this.scenes.add(scene);
        }
    }

    public void addScenes(List<Scene> scenes) {
        if (this.scenes == null) {
            this.scenes = new ArrayList<>();
        }
        this.scenes.addAll(scenes);
    }
    public void addScene(Scene scene) {
        if (this.scenes == null) {
            this.scenes = new ArrayList<>();
        }
        this.scenes.add(scene);
    }
}
