package com.smty.ApiServiciosProfesionales.Models;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "documentos")

public class Documento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_documento")
    private int idDocumento;
	
	@Column(name="url", length = 100)
    private String url;

}
