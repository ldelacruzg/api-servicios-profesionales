package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import java.util.Date;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profesionales")
public class Profesional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_profesional")
	private Long idProfesional;

	@Column(name ="url_sitio_web", length = 100)
	private String urlSitioWeb;

	@Column(name ="url_linkedin", length = 100)
	private String urlLinkedin;

	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//todo: relacion con la entidad usuario
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	//todo:relacion con la entidad ocupacion
	@ManyToOne
	@JoinColumn(name = "id_ocupacion")
	private Ocupacion ocupacion;
}
