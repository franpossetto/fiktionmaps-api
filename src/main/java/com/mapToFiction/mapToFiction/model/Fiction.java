package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
        MOVIE, TV_SHOW, BOOK, SONG
    }

    public enum Provider {
        OMDB_API, TVDB_API, CUSTOM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fictionSeq")
    @SequenceGenerator(name = "fictionSeq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String imgUrl;

    @OneToMany(mappedBy = "fiction", cascade = CascadeType.ALL)
    private List<Scene> scenes = new ArrayList<>();

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
