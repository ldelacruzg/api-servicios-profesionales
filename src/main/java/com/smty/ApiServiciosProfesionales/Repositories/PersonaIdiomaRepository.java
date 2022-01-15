package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.PersonaIdioma;

@Repository
public interface PersonaIdiomaRepository extends JpaRepository<PersonaIdioma, Integer>{

}
