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
    private int idIdioma;
	
	@Column(name="nombre", length = 20)//cambio de longitud de los nombres
    private String nombre;
}
