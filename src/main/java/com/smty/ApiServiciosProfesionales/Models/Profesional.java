package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import java.util.Date;

import javax.persistence.*;

@Data //Crea los constructores así como Getters y Setters.
@Entity //Denotamos que será una Entity, para que lo interprete SPRING.
@Table(name = "profesionales") //Denotamos que será una tabla con un nombre especifico, para que lo trabaje JPA-
public class Profesional {
	@Id //Define la columna inferior como identificador primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Define al identificador como tipo IDENTITY. Autoincrementable.
	@Column(name ="id_profesional")
	private Long idProfesional;

	@Column(name ="url_sitio_web", length = 100)
	private String urlSitioWeb;

	@Column(name ="url_linkedin", length = 100)
	private String urlLinkedin;


	@ManyToOne //Relacion de uno a varios
	@JoinColumn(name = "id_persona") //nombre de la clave foránea.
	private Usuario persona; //Instancia de la clase con la que se va a relacionar.

	@ManyToOne
	@JoinColumn(name = "id_ocupacion")
	private Ocupacion ocupacion;
	
	@Column(name="fecha_registro")
    private Date fechaRegistro;
}
