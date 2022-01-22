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

import com.smty.ApiServiciosProfesionales.Models.ImagenServicio;
import com.smty.ApiServiciosProfesionales.Services.ImagenServicioService;

@RestController
@RequestMapping("api/imagenesservicios")
@CrossOrigin("*")
public class ImagenServicioController {
	@Autowired
	private ImagenServicioService imagenServicioService;
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ImagenServicio>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(imagenServicioService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ImagenServicio> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(imagenServicioService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ImagenServicio> create (@RequestBody ImagenServicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(imagenServicioService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(imagenServicioService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<ImagenServicio>update(@PathVariable Long id, @RequestBody ImagenServicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(imagenServicioService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
