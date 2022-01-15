package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.DocumentoServicio;

@Repository
public interface DocumentoServicioRepository extends JpaRepository<DocumentoServicio, Long>{

}
