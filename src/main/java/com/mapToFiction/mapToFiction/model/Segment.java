package com.mapToFiction.mapToFiction.model;

import javax.persistence.*;

@Entity
@Table(name="segments")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long start_at;
    private long end_at;

    @ManyToOne
    @JoinColumn(name = "scene_id")
    private Scene scene;

    public enum Type {
        MINUTE, PAGE
    }

}
