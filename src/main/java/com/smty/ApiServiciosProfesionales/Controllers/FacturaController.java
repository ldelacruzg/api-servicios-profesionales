package com.smty.ApiServiciosProfesionales.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smty.ApiServiciosProfesionales.Models.Factura;
import com.smty.ApiServiciosProfesionales.Services.FacturaService;

@RestController
@RequestMapping("api/facturas")
@CrossOrigin("*")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Factura>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(facturaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Factura> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(facturaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Factura> create (@RequestBody Factura entity)
    {
        try
        {
            return ResponseEntity.ok().body(facturaService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(facturaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Factura>update(@PathVariable Long id, @RequestBody Factura entity)
    {
        try
        {
            return ResponseEntity.ok().body(facturaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
