package com.mapToFiction.mapToFiction.model;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fictions")
public class Fiction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "fiction")
    private List<Episode> episodes = new ArrayList<Episode>();

    @OneToMany(mappedBy = "fiction")
    private List<Scene> scenes = new ArrayList<Scene>();

    @OneToMany(mappedBy = "fiction")
    private List<Map> maps = new ArrayList<Map>();

    public enum Type {
        MOVIE, TV_SHOW, BOOK, SONG
    }
    public enum Provider {
        OMDB_API, TVDB_API, CUSTOM
    }
}
