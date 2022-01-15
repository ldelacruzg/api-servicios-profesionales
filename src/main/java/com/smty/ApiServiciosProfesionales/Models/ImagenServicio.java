package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "imagen_Servicios")

public class ImagenServicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_imagen_servicio")
	private Long idImagenServicio;
	
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name="id_imagen")
	private Imagen imagen;
}
