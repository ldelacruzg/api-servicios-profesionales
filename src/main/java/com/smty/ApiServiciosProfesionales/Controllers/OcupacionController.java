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

import com.smty.ApiServiciosProfesionales.Models.Ocupacion;
import com.smty.ApiServiciosProfesionales.Services.OcupacionService;

@RestController
@RequestMapping("api/ocupaciones")
@CrossOrigin("*")
public class OcupacionController {
	@Autowired
	private OcupacionService ocupacionService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Ocupacion>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(ocupacionService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Ocupacion> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(ocupacionService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Ocupacion> create (@RequestBody Ocupacion entity)
    {
        try
        {
            return ResponseEntity.ok().body(ocupacionService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ocupacionService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Ocupacion>update(@PathVariable int id, @RequestBody Ocupacion entity)
    {
        try
        {
            return ResponseEntity.ok().body(ocupacionService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
