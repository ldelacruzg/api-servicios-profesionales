package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.PreguntaServicio;

@Repository
public interface PreguntaServicioRepository extends JpaRepository<PreguntaServicio, Integer>{

}
