package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="profesionales_certificaciones")
public class ProfesionalCertificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_profesional_certificacion")
    private Long idProfesionalCertificacion;

    @Column(name ="year")
    private Date year;

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "id_certificacion")
    private Certificacion certificacion ;
}
