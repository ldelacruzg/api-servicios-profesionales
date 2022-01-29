package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profesionales")
public class Profesional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_profesional")
	private Long idProfesional;

	@Column(name ="url_sitio_web", length = 100)
	private String urlSitioWeb;

	@Column(name ="url_linkedin", length = 100)
	private String urlLinkedin;


	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//todo: relacion con la entidad usuario
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	//todo:relacion con la entidad ocupacion
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_ocupacion")
	private Ocupacion ocupacion;

	//todo: lista de certificaciones
	@OneToMany(cascade = {CascadeType.ALL}, targetEntity = Certificacion.class)
	@JoinColumn(name = "id_profesional",referencedColumnName = "id_profesional")
	private Set<Certificacion> certificaciones;
	
	//todo: lista de formaciones
	@OneToMany(cascade = {CascadeType.ALL}, targetEntity = Formacion.class)
	@JoinColumn(name = "id_profesional",referencedColumnName = "id_profesional")
	private Set<Formacion> formaciones;
		
	//todo: lista de habilidades
	@OneToMany(cascade = {CascadeType.ALL}, targetEntity = Habilidad.class)
	@JoinColumn(name = "id_profesional",referencedColumnName = "id_profesional")
	private Set<Habilidad> habilidades;
	
	//todo: lista de idiomas
	@OneToMany(cascade = {CascadeType.ALL}, targetEntity = Idioma.class)
	@JoinColumn(name = "id_profesional",referencedColumnName = "id_profesional")
	private Set<Idioma> idieomas;
		
	
	
	
}
