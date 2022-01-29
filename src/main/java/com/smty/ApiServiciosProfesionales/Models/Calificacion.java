package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "calificaciones")
public class Calificacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_calificacion")
    private Long idCalificacion;
  	
  	@NotEmpty
	@Column(name="calificacion")
    private Short calificacion;
  	
  	@NotEmpty
	@Column(name="comentario")
    private String comentario;
 
  	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="fecha")
	private Date fecha;

}
