package com.smty.ApiServiciosProfesionales.Repositories;

import com.smty.ApiServiciosProfesionales.Models.Formacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacionRepository extends JpaRepository<Formacion,Long> {
}
