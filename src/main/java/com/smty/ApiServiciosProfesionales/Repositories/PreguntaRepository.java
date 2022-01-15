package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer>{

}
