package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "certificaciones")
public class Certificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificacion")
    private int idCertificacion;

    @Column(name = "nombre", length = 80)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais ;


}
