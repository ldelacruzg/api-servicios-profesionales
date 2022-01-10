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
	private SubCategoria subCategoria;
	
	@ManyToOne
	@JoinColumn(name="id_politica_uso")
	private PoliticaUso politicaUso;
	
	@ManyToOne
	@JoinColumn(name="id_profesional")
    private Profesional profesional;
	
	@Column(name="descripcion")
    private String descripcion;
	
	@Column(name="estado")
    private Boolean estado;
}
