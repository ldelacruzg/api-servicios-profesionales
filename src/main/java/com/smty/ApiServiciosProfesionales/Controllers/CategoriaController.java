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

import com.smty.ApiServiciosProfesionales.Models.Categoria;
import com.smty.ApiServiciosProfesionales.Services.CategoriaService;

@RestController
@RequestMapping("api/categorias")
@CrossOrigin("*")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Categoria> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Categoria> create (@RequestBody Categoria entity)
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoriaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Categoria>update(@PathVariable int id, @RequestBody Categoria entity)
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
