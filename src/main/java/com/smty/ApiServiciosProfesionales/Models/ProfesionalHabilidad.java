package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data //Crea los constructores así como Getters y Setters.
@Entity //Denotamos que será una Entity, para que lo interprete SPRING.
@Table(name ="profesionales_habilidades") //Denotamos que será una tabla con un nombre especifico, para que lo trabaje JPA
public class ProfesionalHabilidad {
    @Id //Define la columna inferior como identificador primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define al identificador como tipo IDENTITY. Autoincrementable.
    @Column(name ="id_profesional_habilidad")
    private Long idProfesionalHabilidad;

    @NotEmpty //Es requerido, no permite valores nulos.
    @Column(name ="nivel", length = 30)
    private String nivel;

    @ManyToOne //Relacion de uno a varios
    @JoinColumn(name = "id_profesional") //nombre de la clave foránea.
    private Profesional profesional; //Instancia de la clase con la que se va a relacionar.

    @ManyToOne //Relacion de uno a varios
    @JoinColumn(name = "id_habilidad") //nombre de la clave foránea.
    private Habilidad habilidad; //Instancia de la clase con la que se va a relacionar.
}

