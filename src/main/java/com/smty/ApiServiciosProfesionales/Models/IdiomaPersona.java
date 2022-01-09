package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "idiomas_personas")

public class IdiomaPersona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_idioma_persona")
    private int idIdioma;
	
	@Column(name="nivel", length = 10)//Se agregó un nuevo campo
    private String nivel;
	
	@ManyToOne
	@JoinColumn(name="id_idioma")
	private Idioma idioma;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;
	
}
