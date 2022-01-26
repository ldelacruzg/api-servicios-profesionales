package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "calificaciones")
public class Calificacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_calificacion")
    private Long idCalificacion;
  	
  	@NotEmpty
	@Column(name="calificacion")
    private Short calificacion;
  	
  	@NotEmpty
	@Column(name="comentario")
    private String comentario;

	  //Todo: relación con la entidad servicio
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;

	//Todo: Relacion con la entidad usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
}
