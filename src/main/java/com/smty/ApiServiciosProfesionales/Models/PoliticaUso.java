package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name ="politicas_usos")
public class PoliticaUso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_politica_uso")
    private int idPoliticaUso;

    @NotEmpty
    @Column(name = "descripcion")
    private String descripcion;

}
