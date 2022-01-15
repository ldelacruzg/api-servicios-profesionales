package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.Cotizacion;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer>{

}
