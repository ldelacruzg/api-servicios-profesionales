package com.smty.ApiServiciosProfesionales.Models;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
//proporciona los metodos de obtención y configuración de todas las propiedades de la clase 
@Entity
//Se define que la clase se puede asignar a una tabla 
@Table(name = "documentos")
//Nos permite especificar el nombre de la tabla donde se persistirá la entidad
public class Documento {
	@Id
	//Marca el identificador de la clase, es decir, su clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//Para que el campo sea autoincremental 
	@Column(name="id_documento")
	// La propiedad column name especifica el nombre de la columna donde va a ser persistido el campo
    private Long idDocumento;

    @NotEmpty
 // Se usa en clases de colección
	@Column(name="url", length = 100)
    private String url;

}
