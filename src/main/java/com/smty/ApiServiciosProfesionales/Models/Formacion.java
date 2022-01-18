package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data //Crea los constructores así como Getters y Setters.
@Entity //Denotamos que será una Entity, para que lo interprete SPRING.
@Table(name ="formaciones") //Denotamos que será una tabla con un nombre especifico, para que lo trabaje JPA
public class Formacion {
    @Id //Define la columna inferior como identificador primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define al identificador como tipo IDENTITY. Autoincrementable.
    @Column(name ="id_formacion")
    private int idFormacion;

    @NotEmpty //Es requerido, no permite valores nulos.
    @Column(name ="nombre_institucion", length = 80)
    private String nombreInstitucion;

    @NotEmpty
    @Column(name ="descripcion", length = 50)
    private String descripcion;

    @ManyToOne //Relacion de uno a varios
    @JoinColumn(name = "id_pais") //nombre de la clave foránea.
    private Pais pais; //Instancia de la clase con la que se va a relacionar.
}
