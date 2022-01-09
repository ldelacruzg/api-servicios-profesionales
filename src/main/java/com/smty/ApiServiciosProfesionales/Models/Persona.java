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
	
	@Column(name="nombre", length = 50)//Se modificó la longitud
    private String nombre;
	
	@Column(name="apellido", length = 50)//Se modificó la longitud
    private String apellido;
	
	@Column(name="telefono", length = 15)//Se modificó el nombre del campo
    private String telefono;
	
	@Column(name="direccion", length = 255)
    private String direccion;
	
	@Column(name="url_foto", length = 50)
    private String urlFoto;
	
	@Column(name="descripcion", length = 50)
    private String descripcion;
	
	@Column(name="username", length = 20)
    private String username;
	
	@Column(name="clave", length = 15)
    private String clave;
}
