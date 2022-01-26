package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data

@Entity

@Table(name = "servicios")

public class Servicio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_servicio")
    private Long idServicio;

	@NotEmpty
	@Column(name="nombre", length = 150)
    private String nombre;

	@NotEmpty
	@Column(name="descripcion")
    private String descripcion;

	@Column(name="estado")
    private Boolean estado;
	
	@Column(name="documento",length = 50)
    private String documento;
	
	@Column(name="titulo", length = 200)
    private String titulo;

	@Column(name="fecha_plublicacion")
    private Date fechaPublicacion;

	//todo: relacion con la entidad categoria
	@ManyToOne
	@JoinColumn(name="id_sub_categoria")
	private SubCategoria subCategoria;

	//todo: relacion con la entidad profesional
	@ManyToOne
	@JoinColumn(name="id_profesional")
	private Profesional profesional;
	
	
}