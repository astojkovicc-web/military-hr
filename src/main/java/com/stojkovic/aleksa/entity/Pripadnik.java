package com.stojkovic.aleksa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pripadnik")
@NoArgsConstructor
@Getter
@Setter
public class Pripadnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pripadnik_id")
    private Integer id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false)
    private String rank;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, name = "skolska_sprema")
    private String sprema;

    @Column(nullable = false)
    private String jmbg;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefon;

    @ManyToOne
    @JoinColumn(name = "jedinica_id")
    private Jedinica jedinica;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;
}
