package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
//proporciona los metodos de obtención y configuración de todas las propiedades de la clase 
@Entity
//Se define que la clase se puede asignar a una tabla 
@Table(name = "ocupaciones")
//Nos permite especificar el nombre de la tabla donde se persistirá la entidad
public class Ocupacion {
	@Id
	//Marca el identificador de la clase, es decir, su clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//Para que el campo sea autoincremental 
	@Column(name="id_ocupacion")
	// La propiedad column name especifica el nombre de la columna donde va a ser persistido el campo
    private int idOcupacion;

    @NotEmpty
 // Se usa en clases de colección
	@Column(name="nombre", length = 80)
    private String nombre;
}
