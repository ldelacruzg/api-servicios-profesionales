package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "servicios_planes")

public class ServicioPlan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_servicio_plan")
    private Long idServicioPlan;

	@NotEmpty
	@Column(name="descripcion")
    private String descripcion;

	@NotEmpty
	@Column(name="dias_delivery")
    private Short diasDeliviery;

	@NotEmpty
	@Column(name="precio")
    private Double precio;

	//todo: relacion con la entidad plan
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan plan;

	//todo: relacion con la entidad servicio
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;
}
