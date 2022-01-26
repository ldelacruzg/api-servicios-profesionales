package com.smty.ApiServiciosProfesionales.Repositories;

import com.smty.ApiServiciosProfesionales.Models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {
}
