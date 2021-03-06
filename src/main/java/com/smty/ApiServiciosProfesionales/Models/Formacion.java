package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name ="formaciones")
public class Formacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_formacion")
    private Long idFormacion;

    @NotEmpty
    @Column(name ="nombre_institucion", length = 80)
    private String nombreInstitucion;

    @NotEmpty
    @Column(name ="descripcion", length = 50)
    private String descripcion;
    
    @NotEmpty
    @Column(name="year")
    private String year;

    //Todo: relacion con la entidad pais
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_pais")
    private Pais pais;

}
