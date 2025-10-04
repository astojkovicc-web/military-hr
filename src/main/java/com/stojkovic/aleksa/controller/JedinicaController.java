package com.stojkovic.aleksa.controller;

import com.stojkovic.aleksa.repo.JedinicaRepository;
import com.stojkovic.aleksa.entity.Jedinica;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jedinica")
@CrossOrigin
@RequiredArgsConstructor
public class JedinicaController {

    private final JedinicaRepository repository;

    @GetMapping
    public List<Jedinica> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Jedinica getById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow();
    }
}