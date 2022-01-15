package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

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
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_profesional")
	private Profesional profesional;

	@NotEmpty
	@Column(name="descripcion")
    private String descripcion;

	@NotEmpty
	@Column(name="precio")
    private Double precio;

	@NotEmpty
	@Column(name="dia")
    private Short dia;
	
	
}
