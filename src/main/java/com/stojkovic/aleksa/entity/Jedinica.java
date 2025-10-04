package com.stojkovic.aleksa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "team")
@NoArgsConstructor
@Getter
@Setter
public class Jedinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer id;

    @Column(nullable = false)
    private String nazivTima;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Pripadnik> pripadnik;

    private LocalDateTime deletedAt; // soft delete
}
