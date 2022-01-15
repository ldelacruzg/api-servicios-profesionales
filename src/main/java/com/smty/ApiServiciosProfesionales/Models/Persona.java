package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "personas")

public class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
    private Long idPersona;

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
	
	@Column(name="url_foto", length = 100)
    private String urlFoto;
	
	@Column(name="descripcion")
    private String descripcion;


	@Column(name="username", length = 20)
    private String username;

	@Column(name="clave", length = 15)
    private String clave;

	@NotEmpty
	@Column(name="dni", length = 15)
	private String dni;

	@NotEmpty
	@Column(name="email", length = 50)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;
}
