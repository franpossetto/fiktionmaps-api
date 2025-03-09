package com.fiktionmaps.modules.fiction.domain;

import com.fiktionmaps.modules.place.domain.model.Place;
import com.fiktionmaps.modules.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fictions")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fiction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fictions_id_sequence")
    @SequenceGenerator(name = "fictions_id_sequence", allocationSize = 1)
    private Long id;

    private String name;
    private String externalId;
    private Integer year;
    private Integer duration;
    private String imgUrl;
    private Boolean published;

    @Enumerated(EnumType.STRING)
    private com.fiktionmaps.fiktionmaps.model.Fiction.Type type;

    @Enumerated(EnumType.STRING)
    private com.fiktionmaps.fiktionmaps.model.Fiction.Provider provider;


    @OneToMany(mappedBy = "fiction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Place> places = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

    public enum Type {
        MOVIE, TV_SHOW, EPISODE, BOOK, SONG
    }

    public enum Provider {
        OMDB_API, TVDB_API, CUSTOM
    }
}
