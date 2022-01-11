package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="planes")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_plan")
    private int idPlan;

    @Column(name ="nombre", length = 50)
    private String nombre;
}
