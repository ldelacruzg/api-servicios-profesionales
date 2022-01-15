package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
