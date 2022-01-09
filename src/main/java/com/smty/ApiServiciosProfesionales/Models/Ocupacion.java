package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "ocupaciones")

public class Ocupacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ocupacion")
    private int idOcupacion;
	
	@Column(name="nombre", length = 50)//Se agregó un nueva longitud
    private String nombre;
}
