package com.fiktionmaps.fiktionmaps.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "interests")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interests_id_sequence")
    @SequenceGenerator(name = "interests_id_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fiction_id", nullable = false)
    private Fiction fiction;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
} 