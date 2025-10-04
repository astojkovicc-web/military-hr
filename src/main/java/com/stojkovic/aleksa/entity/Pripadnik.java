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
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String rank;
    private String status;
    private String sprema;
    private String jmbg;
    private String email;
    private String telefon;

    @ManyToOne
    @JoinColumn(name = "jedinica_id")
    private Jedinica jedinica;

    private LocalDateTime postavljenAt;
    private LocalDateTime izmenjenoAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
