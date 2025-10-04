package com.stojkovic.aleksa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "jedinica")
@NoArgsConstructor
@Getter
@Setter
public class Jedinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jedinica_id")
    private Integer jedinicaId;

    @Column(nullable = false)
    private String naziv;

    @OneToMany(mappedBy = "jedinica", cascade = CascadeType.ALL)
    private List<Pripadnik> pripadnici;
}
