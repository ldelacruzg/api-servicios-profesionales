package com.smty.ApiServiciosProfesionales.Repositories;

import com.smty.ApiServiciosProfesionales.Models.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
