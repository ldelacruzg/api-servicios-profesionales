package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "cotizaciones")

public class Cotizaciones {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cotizar")
    private int idCotizar;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Idioma idcliente;
	
	@ManyToOne
	@JoinColumn(name="id_profesional")
	private Idioma idprofesional;
	
	@Column(name="descripcion", length = 100)//Se agregó un nueva longitud
    private String descripcion;
	
	//@Column(name="precio", length = 100)//Se agregó un nueva longitud
    // private decimal precio; corregir
	
	@Column(name="dia")//Se agregó un nueva longitud
    private int dia;
	
	
}
