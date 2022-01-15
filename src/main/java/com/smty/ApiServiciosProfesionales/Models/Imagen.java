package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "imagenes")


public class Imagen {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_imagen")
    private Long idImagen;

    @NotEmpty
	@Column(name="url", length = 100)
    private String url;
	
}
