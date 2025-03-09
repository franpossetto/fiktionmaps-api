package com.fiktionmaps.modules.place.domain.model;

import com.fiktionmaps.modules.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "scenes")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scenes_id_sequence")
    @SequenceGenerator(name = "scenes_id_sequence", initialValue = 1000, allocationSize = 1)
    private Long id;

    private String name;
    private String description;
    private String season;
    private String episodeName;
    private String episodeNumber;
    private Long startAt;
    private Long endAt;
    private String screenshot;
    private Boolean published;

    @Enumerated(EnumType.STRING)
    private com.fiktionmaps.fiktionmaps.model.Scene.SegmentType segmentType;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

    public enum SegmentType {
        MINUTE, PAGE
    }

}
