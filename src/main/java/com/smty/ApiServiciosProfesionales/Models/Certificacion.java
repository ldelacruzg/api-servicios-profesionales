package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "certificaciones")
public class Certificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificacion")
    private int idCertificacion;

    @NotEmpty
    @Column(name = "nombre", length = 80)
    private String nombre;

    @NotEmpty
    @Column(name="year")
    private String year;

    //todo: relacion con la entidad profesional
    @ManyToOne
    @JoinColumn(name="id_profesional")
    private Profesional profesional;

}
