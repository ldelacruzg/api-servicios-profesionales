package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "cotizaciones")
public class Cotizacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cotizar")
    private int idCotizar;

	@NotEmpty
	@Column(name="descripcion")
    private String descripcion;

	@NotEmpty
	@Column(name="precio")
    private Double precio;

	@NotEmpty
	@Column(name="dias_espera")
    private Short dias_espera;
	
	@Column(name="fecha_cotizacion")
    private Date fechaCotizacion;
	
	@Column(name="documento", length = 50)
    private String documento;

	//todo: relacion con la entidad usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//todo: relacion con la entidad profesional
	@ManyToOne
	@JoinColumn(name="id_profesional")
	private Profesional profesional;
}
