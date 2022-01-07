package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "profesionales")
public class Profesional implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfesional;
	private String urlSitioWeb;
	private String urlLinkedin;

	//private Persona persona;
	//@ManyToOne
	//@JoinColumn(name = "id_persona")
}
