package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
//proporciona los metodos de obtención y configuración de todas las propiedades de la clase 
@Entity
//Se define que la clase se puede asignar a una tabla 
@Table(name = "documentos_servicios")
//Nos permite especificar el nombre de la tabla donde se persistirá la entidad
public class DocumentoServicio {
	@Id
	//Marca el identificador de la clase, es decir, su clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//Para que el campo sea autoincremental 
	@Column(name="id_documento_servicio")
	// La propiedad column name especifica el nombre de la columna donde va a ser persistido el campo
    private Long idDocumentoServicio;
	
	@ManyToOne
	//Se encarga de generar una relación de muchos a uno
	@JoinColumn(name="id_servicios")
	//Es para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación.
	private Servicio servicio;
	
	@ManyToOne
	//Se encarga de generar una relación de muchos a uno
	@JoinColumn(name="id_documentos")
	//Es para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación.
	private Documento documento;

}
