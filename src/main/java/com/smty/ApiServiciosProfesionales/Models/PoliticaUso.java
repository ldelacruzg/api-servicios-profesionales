package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data //Crea los constructores así como Getters y Setters.
@Entity //Denotamos que será una Entity, para que lo interprete SPRING.
@Table(name ="politicas_usos")
public class PoliticaUso {
    @Id //Define la columna inferior como identificador primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define al identificador como tipo IDENTITY. Autoincrementable.
    @Column(name = "id_politica_uso")
    private int idPoliticaUso;

    @NotEmpty //Es requerido, no permite valores nulos.
    @Column(name = "descripcion")
    private String descripcion;

}
