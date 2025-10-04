package com.stojkovic.aleksa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stojkovic.aleksa.entity.Jedinica;
import java.util.List;

public interface JedinicaRepository extends JpaRepository<Jedinica, Integer> {
}
