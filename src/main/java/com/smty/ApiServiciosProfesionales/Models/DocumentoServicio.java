package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "documentos_servicios")

public class DocumentoServicio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_documento_servicios")
    private int idDocumentoServicios;
	
	//@ManyToOne
	//@JoinColumn(name="id_servicios")
	//private Servicios servicios;//     falta esta tabla
	
	@ManyToOne
	@JoinColumn(name="id_documentos")
	private Documento documentos;

}
