package com.smty.ApiServiciosProfesionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smty.ApiServiciosProfesionales.Models.ServicioPlan;

@Repository
public interface ServicioPlanRepository extends JpaRepository<ServicioPlan, Integer>{

}
