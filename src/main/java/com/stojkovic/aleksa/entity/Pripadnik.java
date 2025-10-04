package com.stojkovic.aleksa.entity;

public class Employee {

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Pripadnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
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
    @JoinColumn(name = "team_id")
    private Team team;

    private LocalDateTime deletedAt;
}