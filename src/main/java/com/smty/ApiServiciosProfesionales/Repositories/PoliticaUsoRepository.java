package com.smty.ApiServiciosProfesionales.Repositories;

import com.smty.ApiServiciosProfesionales.Models.PoliticaUso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticaUsoRepository extends JpaRepository<PoliticaUso, Integer> {
}
