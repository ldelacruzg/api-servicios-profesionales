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
	
	@Column(name="descripcion")
    private String descripcion;
	
	@Column(name="respuesta")
    private String respuesta;
}
