package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

	@NotEmpty
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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

	//todo: lista de certificaciones
	@OneToMany(mappedBy = "certificacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Certificacion> certificacion = new ArrayList<>();

	//todo: lista de habilidades
	@OneToMany(mappedBy = "habilidad", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Habilidad> habilidad = new ArrayList<>();

	//todo: lista de formaciones
	@OneToMany(mappedBy = "formacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Formacion> formacion = new ArrayList<>();
}
