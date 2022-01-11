package com.smty.ApiServiciosProfesionales.Repositories;

import com.smty.ApiServiciosProfesionales.Models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Integer> {
}
