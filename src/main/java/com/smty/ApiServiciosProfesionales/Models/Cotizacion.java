package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
//proporciona los metodos de obtención y configuración de todas las propiedades de la clase 
@Entity
//Se define que la clase se puede asignar a una tabla 
@Table(name = "cotizaciones")
//Nos permite especificar el nombre de la tabla donde se persistirá la entidad
public class Cotizacion {

	@Id
	//Marca el identificador de la clase, es decir, su clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//Para que el campo sea autoincremental 
	@Column(name="id_cotizar")
	// La propiedad column name especifica el nombre de la columna donde va a ser persistido el campo
    private int idCotizar;
	
	@ManyToOne
	//Se encarga de generar una relación de muchos a uno
	@JoinColumn(name="id_cliente")
	//Es para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación.
	private Cliente cliente;
	
	@ManyToOne
	//Se encarga de generar una relación de muchos a uno
	@JoinColumn(name="id_profesional")
	//Es para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación.
	private Profesional profesional;

	@NotEmpty
	//Se encarga de generar una relación de muchos a uno
	@Column(name="descripcion")
	//Es para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación.
    private String descripcion;

	@NotEmpty
	//Se encarga de generar una relación de muchos a uno
	@Column(name="precio")
	//Es para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación.
    private Double precio;

	@NotEmpty
	//Se encarga de generar una relación de muchos a uno
	@Column(name="dia")
	//Es para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación.
    private Short dia;
	
	@Column(name="fecha_cotizacion")
    private Date fechaCotizacion;
	
	@Column(name="url_doc")
    private String urlDoc;
}
