package com.stojkovic.aleksa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stojkovic.aleksa.entity.Pripadnik;
import java.util.List;

public interface PripadnikRepository extends JpaRepository<Pripadnik, Integer> {
    List<Pripadnik> findAllByDeletedAtIsNull();
    List<Pripadnik> findAllByJedinica_JedinicaIdAndDeletedAtIsNull(Integer jedinicaId);
}
