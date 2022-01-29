package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name= "imagenes")
public class Imagen {
    @Id
    @Column(name= "id_imagen")
    private Long idImagen;

    @Column(name= "imagen", length=50)
    private String imagen;

}
