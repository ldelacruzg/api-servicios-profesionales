package com.smty.ApiServiciosProfesionales.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profesionales")
public class Profesional {
   private Long idProfesional;
   private String urlSitioWeb;
}
