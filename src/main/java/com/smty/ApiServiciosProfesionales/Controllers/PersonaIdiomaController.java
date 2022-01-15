package com.smty.ApiServiciosProfesionales.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smty.ApiServiciosProfesionales.Models.PersonaIdioma;
import com.smty.ApiServiciosProfesionales.Services.PersonaIdiomaService;

@RestController
@RequestMapping("api/personasidiomas")
public class PersonaIdiomaController {
	@Autowired
	private PersonaIdiomaService personaIdiomaService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<PersonaIdioma>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(personaIdiomaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<PersonaIdioma> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(personaIdiomaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<PersonaIdioma> create (@RequestBody PersonaIdioma entity)
    {
        try
        {
            return ResponseEntity.ok().body(personaIdiomaService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaIdiomaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<PersonaIdioma>update(@PathVariable Long id, @RequestBody PersonaIdioma entity)
    {
        try
        {
            return ResponseEntity.ok().body(personaIdiomaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}