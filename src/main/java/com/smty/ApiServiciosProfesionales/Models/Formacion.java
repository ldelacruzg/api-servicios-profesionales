package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="formaciones")
public class Formacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_formacion")
    private int idFormacion;

    @Column(name ="nombre_institucion", length = 80)
    private String nombreInstitucion;

    @Column(name ="descripcion", length = 50)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
}
