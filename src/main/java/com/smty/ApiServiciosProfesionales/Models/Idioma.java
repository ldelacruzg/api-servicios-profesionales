package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "idiomas")
public class Idioma {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_idioma")
    private int Idioma;
	
	@Column(name="nombre", length = 30)
    private String nombre;
}