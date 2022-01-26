package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//La anotación @Data proporciona los métodos de obtención y configuración de
//de las propiedades de la clase
@Data

//La anotacion @Entity define que la clase se puede asignar a una tabla
@Entity

//La anotación @Table permite especificar el nombre de la tabla donde se
//persistirá la entidad
@Table(name = "preguntas")

public class Pregunta {
	//La anotación @Id marca el identificador de la tabla, es decir, su clave primaria
	@Id
	
	//La anotación @GeneratedValue sirve para que el campo sea autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//La anotación @Column sirve para darle el nombre a una columna de la tabla,
	//así mismo se puede configurar el lenght
	@Column(name="id_pregunta")
    private Long idPregunta;
	
	//La anotación @NotEmpty sirve para especificar que que el valor debe
	//ser mayor a 0
    @NotEmpty
	@Column(name="descripcion")
    private String descripcion;

    @NotEmpty
	@Column(name="respuesta")
    private String respuesta;
    
    @ManyToOne
	@JoinColumn(name="id_servicio")
    private Servicio servicio;
}
