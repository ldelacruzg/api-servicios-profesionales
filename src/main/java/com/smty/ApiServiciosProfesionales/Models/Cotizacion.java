package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
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
	
	@Column(name="descripcion")
    private String descripcion;
	
	@Column(name="precio")
    private Double precio;
	
	@Column(name="dia")
    private Short dia;
	
	
}
