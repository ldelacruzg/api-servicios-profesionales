package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "personas_idiomas")

public class PersonasIdiomas {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona_idioma")
    private int idPersonaIdioma;
	
	@ManyToOne
	@JoinColumn(name="id_idioma")
	private Idioma idIdioma;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona idPersona;
	
	@Column(name="nivel", length = 30)
    private String nivel;	
}
