package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "personas_idiomas")

public class PersonaIdioma {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona_idioma")
    private Long idPersonaIdioma;
	
	@ManyToOne
	@JoinColumn(name="id_idioma")
	private Idioma Idioma;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona Persona;
	
	@Column(name="nivel", length = 30)
    private String nivel;	
}
