package com.smty.ApiServiciosProfesionales.Models;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Categorias")
public class Categoria {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_categoria")
	    private int idCategoria;

	    @Column(name = "nombre", length = 50) //cambio de la longitud
	    private String nombre;

}
