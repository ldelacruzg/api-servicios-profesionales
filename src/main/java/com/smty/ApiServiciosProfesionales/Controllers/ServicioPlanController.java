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

import com.smty.ApiServiciosProfesionales.Models.ServicioPlan;
import com.smty.ApiServiciosProfesionales.Services.ServicioPlanService;

@RestController
@RequestMapping("api/serviciosplanes")
public class ServicioPlanController {
	@Autowired
	private ServicioPlanService servicioPlanService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ServicioPlan>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(servicioPlanService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ServicioPlan> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(servicioPlanService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ServicioPlan> create (@RequestBody ServicioPlan entity)
    {
        try
        {
            return ResponseEntity.ok().body(servicioPlanService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicioPlanService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<ServicioPlan>update(@PathVariable Long id, @RequestBody ServicioPlan entity)
    {
        try
        {
            return ResponseEntity.ok().body(servicioPlanService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
