package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data //Crea los constructores así como Getters y Setters.
@Entity //Denotamos que será una Entity, para que lo interprete SPRING.
@Table(name ="profesionales_formaciones") //Denotamos que será una tabla con un nombre especifico, para que lo trabaje JPA
public class ProfesionalFormacion {
    @Id //Define la columna inferior como identificador primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define al identificador como tipo IDENTITY. Autoincrementable.
    @Column(name ="id_profesional_formacion")
    private Long idProfesionalFormacion;

    @NotEmpty //Es requerido, no permite valores nulos.
    @Column(name ="year")
    private Date year;

    @ManyToOne //Relacion de uno a varios
    @JoinColumn(name = "id_profesional") //nombre de la clave foránea.
    private Profesional profesional; //Instancia de la clase con la que se va a relacionar.

    @ManyToOne
    @JoinColumn(name = "id_formacion")
    private Formacion formacion;

}
