package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "personas")

public class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
    private Long idPersona;
	
	@Column(name="nombre", length = 100)
    private String nombre;
	
	@Column(name="apellido", length = 100)
    private String apellido;
	
	@Column(name="telefono", length = 15)
    private String telefono;
	
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
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;
}
