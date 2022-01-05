package com.smty.ApiServiciosProfesionales.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profesionales")
public class Profesional implements Serializable {
   private Long idProfesional;
   private String urlSitioWeb;
}
