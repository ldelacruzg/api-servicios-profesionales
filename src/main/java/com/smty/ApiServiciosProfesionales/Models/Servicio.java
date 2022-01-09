package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "servicios")

public class Servicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_servicio")
    private Long idServicio;
	
	@ManyToOne
	@JoinColumn(name="id_sub_categoria")
	private SubCategoria idSubCategoria;
	
	@ManyToOne
	@JoinColumn(name="id_politica_uso")
	private PoliticaUso idPoliticaUso;
	
	@ManyToOne
	@Column(name="id_profesional")
    private Profesional idProfesional;
	
	@Column(name="descripcion", length = 80)
    private String descripcion;
	
	@Column(name="estado")
    private Boolean estad;
}
