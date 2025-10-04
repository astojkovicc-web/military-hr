package com.stojkovic.aleksa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.stojkovic.aleksa.entity.Pripadnik;
import com.stojkovic.aleksa.repo.PripadnikRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/pripadnik")
@CrossOrigin
@RequiredArgsConstructor
public class PripadnikController {

    private final PripadnikRepository repository;

    @GetMapping
    public List<Pripadnik> getCustomer() {
        return repository.findAllByDeletedAtIsNull();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pripadnik> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @GetMapping("/jedinica/{jedinicaId}")
    public List<Pripadnik> getByJedinica(@PathVariable Integer jedinicaId) {
        return repository.findAllByJedinica_JedinicaIdAndDeletedAtIsNull(jedinicaId);
    }

    @PostMapping
    public Pripadnik save(@RequestBody Pripadnik model) {
        Pripadnik pripadnik = new Pripadnik();
        pripadnik.setIme(model.getIme());
        pripadnik.setPrezime(model.getPrezime());
        pripadnik.setRank(model.getRank());
        pripadnik.setStatus(model.getStatus());
        pripadnik.setSprema(model.getSprema());
        pripadnik.setJmbg(model.getJmbg());
        pripadnik.setEmail(model.getEmail());
        pripadnik.setTelefon(model.getTelefon());
        pripadnik.setJedinica(model.getJedinica());
        pripadnik.setUpdatedAt(LocalDateTime.now());
        return repository.save(pripadnik);
    }

    @PutMapping("/{id}")
    public Pripadnik update(@PathVariable Integer id, @RequestBody Pripadnik model) {
        Pripadnik pripadnik = repository.findById(id).orElseThrow();
        pripadnik.setIme(model.getIme());
        pripadnik.setPrezime(model.getPrezime());
        pripadnik.setRank(model.getRank());
        pripadnik.setStatus(model.getStatus());
        pripadnik.setSprema(model.getSprema());
        pripadnik.setJmbg(model.getJmbg());
        pripadnik.setEmail(model.getEmail());
        pripadnik.setTelefon(model.getTelefon());
        pripadnik.setJedinica(model.getJedinica());
        pripadnik.setUpdatedAt(LocalDateTime.now());
        return repository.save(pripadnik);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Pripadnik pripadnik = repository.findById(id).orElseThrow();
        pripadnik.setDeletedAt(LocalDateTime.now());
        repository.save(pripadnik);
    }
}
