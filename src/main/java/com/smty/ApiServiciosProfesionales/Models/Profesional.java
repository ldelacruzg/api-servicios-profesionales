package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profesionales")
public class Profesional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_profesional")
	private Long idProfesional;

	@Column(name ="url_sitio_web", length = 80)
	private String urlSitioWeb;

	@Column(name ="url_linkedin", length = 80)
	private String urlLinkedin;

	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "id_ocupacion")
	private Ocupacion ocupacion;

	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;

}
