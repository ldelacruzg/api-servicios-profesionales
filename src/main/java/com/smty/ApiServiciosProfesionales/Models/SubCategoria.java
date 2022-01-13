package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "sub_categorias")
public class SubCategoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sub_categoria")
    private int idSubCategoria;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@Column(name="nombre", length = 50)
    private String nombre;
}