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

import com.smty.ApiServiciosProfesionales.Models.PreguntaServicio;
import com.smty.ApiServiciosProfesionales.Services.PreguntaServicioService;

@RestController
@RequestMapping("api/preguntasservicios")
@CrossOrigin("*")
public class PreguntaServicioController {
	@Autowired
	private PreguntaServicioService preguntaServicioService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<PreguntaServicio>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(preguntaServicioService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<PreguntaServicio> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(preguntaServicioService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<PreguntaServicio> create (@RequestBody PreguntaServicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(preguntaServicioService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(preguntaServicioService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<PreguntaServicio>update(@PathVariable Long id, @RequestBody PreguntaServicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(preguntaServicioService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
