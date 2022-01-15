package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "preguntas")

public class Pregunta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pregunta")
    private int idPregunta;

    @NotEmpty
	@Column(name="descripcion")
    private String descripcion;

    @NotEmpty
	@Column(name="respuesta")
    private String respuesta;
}
