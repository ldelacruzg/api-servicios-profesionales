package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.UsuarioIdioma;

@Repository
public interface UsuarioIdiomaRepository extends JpaRepository<UsuarioIdioma, Long>{

}
