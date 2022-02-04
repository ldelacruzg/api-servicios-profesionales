package com.smty.ApiServiciosProfesionales.Controllers;

import com.smty.ApiServiciosProfesionales.Models.Calificacion;
import com.smty.ApiServiciosProfesionales.Services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calificaciones")
@CrossOrigin("*")

public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Calificacion>> getAll() {
        try {
            return ResponseEntity.ok().body(calificacionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Calificacion> finfById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(calificacionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Calificacion> create(@RequestBody Calificacion entity) {
        try {
            return ResponseEntity.ok().body(calificacionService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(calificacionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value = "{id}")
    private ResponseEntity<Calificacion> update(@PathVariable Long id, @RequestBody Calificacion entity) {
        try {
            return ResponseEntity.ok().body(calificacionService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
