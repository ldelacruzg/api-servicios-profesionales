package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "clientes")

public class Cliente {
	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
   private Long idCliente;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Idioma idioma;

}
