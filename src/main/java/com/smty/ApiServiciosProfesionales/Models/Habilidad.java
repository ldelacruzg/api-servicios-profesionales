package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "habilidades")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_habilidad", length = 50)
    private int idHabilidad;

    @NotEmpty
    @Column(name ="nombre")
    private String nombre;

    @Column(name ="fecha_desde")
    private String fechaDesde;

    @Column(name ="descripcion")
    private String descripcion;
}
