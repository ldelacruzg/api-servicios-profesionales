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
	private Categoria categoria;// el nombre de la clase y  minuscula 
	
	@Column(name="nombre", length = 50)//Se agregó un nuevo campo, cambiar en el leng
    private String nombre;
}
