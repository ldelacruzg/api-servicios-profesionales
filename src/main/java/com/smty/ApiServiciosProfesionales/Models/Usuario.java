package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//La anotación @Data proporciona los métodos de obtención y configuración de
//de las propiedades de la clase
@Data

//La anotacion @Entity define que la clase se puede asignar a una tabla
@Entity

//La anotación @Table permite especificar el nombre de la tabla donde se
//persistirá la entidad
@Table(name = "usuarios")

public class Usuario {
	//La anotación @Id marca el identificador de la tabla, es decir, su clave primaria
	@Id
	
	//La anotación @GeneratedValue sirve para que el campo sea autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//La anotación @Column sirve para darle el nombre a una columna de la tabla,
	//así mismo se puede configurar el lenght
	@Column(name="id_usuario")
    private Long idUsuario;
	
	//La anotación @NotEmpty sirve para especificar que que el valor debe
	//ser mayor a 0
	@NotEmpty
	@Column(name="nombre", length = 100)
    private String nombre;

	@NotEmpty
	@Column(name="apellido", length = 100)
    private String apellido;
	
	@Column(name="telefono", length = 15)
    private String telefono;

	@NotEmpty
	@Column(name="direccion")
    private String direccion;
	
	@Column(name="url_foto")
    private String urlFoto;
	
	@Column(name="descripcion")
    private String descripcion;

	@Column(name="clave")
    private String clave;

	@NotEmpty
	@Column(name="dni", length = 15)
	private String dni;

	@Email
	@Column(name="email", length = 50)
	private String email;
	
	//La anotación @ManyToOne significa que hay una relación de muchos a uno
	@ManyToOne
	
	//La anotación @JoinColumn sirve para especificar cuál será la clave
	//foránea. Así mismo se crea una instancia de la clase Pais para
	//poder hacer referencia que en aquella clase está la clave foránea
	@JoinColumn(name="id_pais")
	private Pais pais;
	
	@NotEmpty
	@Column(name="tipo_usuario", length = 15)
	private Short tipoUsuario;
}
