package com.smty.ApiServiciosProfesionales.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

//La anotación @Data proporciona los métodos de obtención y configuración de
//de las propiedades de la clase
@Data

//La anotacion @Entity define que la clase se puede asignar a una tabla
@Entity

//La anotación @Table permite especificar el nombre de la tabla donde se
//persistirá la entidad
@Table(name = "facturas")

public class Factura {
	//La anotación @Id marca el identificador de la tabla, es decir, su clave primaria
	@Id
	
	//La anotación @GeneratedValue sirve para que el campo sea autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//La anotación @Column sirve para darle el nombre a una columna de la tabla,
	//así mismo se puede configurar el lenght
	@Column(name="id_factura")
    private Long idFactura;
	
	//La anotación @ManyToOne significa que hay una relación de muchos a uno
	@ManyToOne
	
	//La anotación @JoinColumn sirve para especificar cuál será la clave
	//foránea. Así mismo se crea una instancia de la clase Cliente para
	//poder hacer referencia que en aquella clase está la clave foránea
	@JoinColumn(name="id_cliente")
	private Cliente Cliente;
	
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio Servicio;
	
	//La anotación @NotEmpty sirve para especificar que que el valor debe
	//ser mayor a 0
	@NotEmpty
	@Column(name="fecha")
    private Date fecha;


	@Column(name="total")
    private Double total;


	@Column(name="estado")
    private Boolean estado;
}
