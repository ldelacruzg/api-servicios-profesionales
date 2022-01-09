package com.smty.ApiServiciosProfesionales.Models;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "documentos")

public class Documentos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_documentos")
    private int idDocumentos;
	
	@Column(name="url", length = 100)//Se agregó un nueva longitud
    private String url;

}
