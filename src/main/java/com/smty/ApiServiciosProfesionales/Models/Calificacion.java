package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

//La anotación @Data proporciona los métodos de obtención y configuración de
//de las propiedades de la clase
@Data

//La anotacion @Entity define que la clase se puede asignar a una tabla
@Entity

//La anotación @Table permite especificar el nombre de la tabla donde se
//persistirá la entidad
@Table(name = "calificaciones")

public class Calificacion {
	@Id
	//Marca el identificador de la clase, es decir, su clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//Para que el campo sea autoincremental 
	@Column(name="id_calificacion")
	// La propiedad column name especifica el nombre de la columna donde va a ser persistido el campo
    private Long id_calificacion;
	
	//La anotación @ManyToOne significa que hay una relación de muchos a uno
  	@ManyToOne
  	
  	//La anotación @JoinColumn sirve para especificar cuál será la clave
  	//foránea. Así mismo se crea una instancia de la clase SubCategoria para
  	//poder hacer referencia que en aquella clase está la clave foránea
  	@JoinColumn(name="id_servicio")
  	private Servicio servicio;
  	
  	@ManyToOne
  	@JoinColumn(name="id_usuario")
  	private Usuario usuario;
  	
  	@NotEmpty
    // Se usa en clases de colección
	@Column(name="calificacion")
    private Short calificacion;
  	
  	@NotEmpty
	@Column(name="comentario")
    private String comentario;
}
