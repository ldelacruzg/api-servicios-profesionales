package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "preguntas")

public class Pregunta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pregunta")
    private int idPregunta;
	
	@Column(name="descripcion", length = 100)
    private String descripcion;
	
	@Column(name="respuesta", length = 10)
    private String respuesta;
}
