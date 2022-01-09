package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "personas")

public class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
    private int idPersona;
	
	@Column(name="nombre", length = 50)//Se modificó la longitud
    private String nombre;
	
}
