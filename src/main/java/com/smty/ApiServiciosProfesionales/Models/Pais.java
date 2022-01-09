package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "paises")

public class Pais {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pais")
    private int idPais;
	
	@Column(name="nombre", length = 51)//Se modificó la longitud
    private String nombre;
}
