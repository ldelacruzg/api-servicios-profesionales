package com.smty.ApiServiciosProfesionales.Models;
import lombok.Data;

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

}
