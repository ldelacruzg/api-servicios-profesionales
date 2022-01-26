package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuarios_idiomas")
public class UsuarioIdioma {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario_idioma")
    private Long idUsuarioIdioma;

	@Column(name="nivel", length = 30)
	private String nivel;

	//todo: relacion con la entidad idioma
	@ManyToOne
	@JoinColumn(name="id_idioma")
	private Idioma Idioma;

	//todo: relacion con la entidad usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

}
