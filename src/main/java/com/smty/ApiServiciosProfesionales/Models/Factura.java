package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@Entity
@Table(name = "facturas")

public class Factura {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_factura")
    private Long idFactura;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente Cliente;
	
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio Servicio;

	@NotEmpty
	@Column(name="fecha")
    private Date fecha;


	@Column(name="total")
    private Double total;


	@Column(name="estado")
    private Boolean estado;
}
