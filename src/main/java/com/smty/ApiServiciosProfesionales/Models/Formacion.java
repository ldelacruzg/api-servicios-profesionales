package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name ="formaciones")
public class Formacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormacion;
    private String nombreInstitucion;
    private String descripcion;

    //private Pais pais;
    //@ManyToOne
    //@JoinColumn(name = "id_pais")
}
