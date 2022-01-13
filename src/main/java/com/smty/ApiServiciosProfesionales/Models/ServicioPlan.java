package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "servicios_planes")

public class ServicioPlan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_servicio_plan")
    private Long idServicioPlan;
	
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan plan;
	
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;
	
	@Column(name="descripcion")
    private String descripcion;
	
	@Column(name="dias_delivery")
    private Short diasDeliviery;
	
	@Column(name="precio")
    private Double precio;
}