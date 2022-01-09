package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "preguntas_servicios")

public class PreguntaServicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pregunta_servicio")
    private Long idPreguntaServicio;
	
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio idServicio;
	
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Pregunta idPregunt;
}
