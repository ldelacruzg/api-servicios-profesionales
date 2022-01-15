package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.Ocupacion;

@Repository
public interface OcupacionRepository extends JpaRepository<Ocupacion, Integer>{

}
