package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data //Crea los constructores así como Getters y Setters.
@Entity //Denotamos que será una Entity, para que lo interprete SPRING.
@Table(name = "certificaciones") //Denotamos que será una tabla con un nombre especifico, para que lo trabaje JPA-
public class Certificacion {
    @Id //Define la columna inferior como identificador primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define al identificador como tipo IDENTITY. Autoincrementable.
    @Column(name = "id_certificacion")
    private int idCertificacion;

    @NotEmpty //Es requerido, no permite valores nulos.
    @Column(name = "nombre", length = 80)
    private String nombre;


}
