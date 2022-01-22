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

import com.smty.ApiServiciosProfesionales.Models.DocumentoServicio;
import com.smty.ApiServiciosProfesionales.Services.DocumentoServicioService;

@RestController
@RequestMapping("api/documentosservicios")
@CrossOrigin("*")
public class DocumentoServicioController {
	@Autowired
	private DocumentoServicioService documentoServicioService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<DocumentoServicio>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(documentoServicioService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<DocumentoServicio> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(documentoServicioService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<DocumentoServicio> create (@RequestBody DocumentoServicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(documentoServicioService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(documentoServicioService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<DocumentoServicio>update(@PathVariable Long id, @RequestBody DocumentoServicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(documentoServicioService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
