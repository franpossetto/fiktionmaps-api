package com.mapToFiction.mapToFiction.model;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fictions")
public class Fiction {

    @Id
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "fiction")
    private List<Scene> scenes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public enum Type {
        MOVIE, TV_SHOW, BOOK, SONG
    }

    public Fiction(){}


}
