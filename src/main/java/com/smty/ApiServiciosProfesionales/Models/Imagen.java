package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "imagenes")


public class Imagen {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_imagen")
    private int idImagen;
	
	@Column(name="url", length = 100)
    private String url;
	
}
