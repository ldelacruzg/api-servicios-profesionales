package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "documentos_servicios")

public class DocumentoServicio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_documento_servicio")
    private Long idDocumentoServicio;
	
	@ManyToOne
	@JoinColumn(name="id_servicios")
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name="id_documentos")
	private Documento documento;

}
