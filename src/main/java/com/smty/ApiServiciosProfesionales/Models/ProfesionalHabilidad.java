package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profesionales_habilidades")
public class ProfesionalHabilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_profesional_habilidad")
    private Long idProfesionalHabilidad;

    @Column(name ="nivel", length = 30)
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "id_habilidad")
    private Habilidad habilidad;
}

