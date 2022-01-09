package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "imagen_Servicios")

public class ImagenServicio {
	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_imagen_servicios")
	    private int idImagenServicios;
		
	  //  @ManyToOne
		//@JoinColumn(name="id_servicios") // falta 
		//private Servicios servicios;
		
		@ManyToOne
		@JoinColumn(name="id_imagen")
		private Imagen imagen;

}
