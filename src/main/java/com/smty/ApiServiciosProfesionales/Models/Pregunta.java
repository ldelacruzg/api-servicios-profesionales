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
    private Long idPregunta;
	

    @NotEmpty
	@Column(name="descripcion")
    private String descripcion;

    @NotEmpty
	@Column(name="respuesta")
    private String respuesta;

    //todo: relacion con la entidad servicio
    @ManyToOne
	@JoinColumn(name="id_servicio")
    private Servicio servicio;
}
