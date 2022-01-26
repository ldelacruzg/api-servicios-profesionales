package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;

//La anotación @Data proporciona los métodos de obtención y configuración de
//de las propiedades de la clase
@Data

//La anotacion @Entity define que la clase se puede asignar a una tabla
@Entity

//La anotación @Table permite especificar el nombre de la tabla donde se
//persistirá la entidad
@Table(name = "usuarios_idiomas")

public class UsuarioIdioma {
	//La anotación @Id marca el identificador de la tabla, es decir, su clave primaria
	@Id
	
	//La anotación @GeneratedValue sirve para que el campo sea autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//La anotación @Column sirve para darle el nombre a una columna de la tabla,
	//así mismo se puede configurar el lenght
	@Column(name="id_usuario_idioma")
    private Long idUsuarioIdioma;
	
	//La anotación @ManyToOne significa que hay una relación de muchos a uno
	@ManyToOne
	
	//La anotación @JoinColumn sirve para especificar cuál será la clave
	//foránea. Así mismo se crea una instancia de la clase Idioma para
	//poder hacer referencia que en aquella clase está la clave foránea
	@JoinColumn(name="id_idioma")
	private Idioma Idioma;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Column(name="nivel", length = 30)
    private String nivel;	
}