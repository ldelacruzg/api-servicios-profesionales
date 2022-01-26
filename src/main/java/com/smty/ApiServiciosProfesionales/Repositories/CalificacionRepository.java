package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{

}
