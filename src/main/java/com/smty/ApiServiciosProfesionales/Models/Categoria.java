package com.smty.ApiServiciosProfesionales.Models;
import lombok.Data;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "Categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private int idCategoria;

	@NotEmpty
	@Column(name = "nombre", length = 50)
	private String nombre;

	//todo: lista de formaciones
	@OneToMany(cascade = {CascadeType.ALL}, targetEntity = SubCategoria.class)
	@JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria")
	private Set<SubCategoria> subcategorias;

}
