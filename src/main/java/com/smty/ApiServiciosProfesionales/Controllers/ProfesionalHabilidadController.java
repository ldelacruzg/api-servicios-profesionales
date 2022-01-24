package com.smty.ApiServiciosProfesionales.Controllers;
import com.smty.ApiServiciosProfesionales.Models.ProfesionalHabilidad;
import com.smty.ApiServiciosProfesionales.Services.ProfesionalHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/profesionales_habilidades")
@CrossOrigin("*")
public class ProfesionalHabilidadController {
    @Autowired
    private ProfesionalHabilidadService profesionalHabilidadService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ProfesionalHabilidad>> getAll() {
        try {
            return ResponseEntity.ok().body(profesionalHabilidadService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ProfesionalHabilidad> finfById(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok().body(profesionalHabilidadService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ProfesionalHabilidad> create (@RequestBody ProfesionalHabilidad entity) {
        try {
            return ResponseEntity.ok().body(profesionalHabilidadService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(profesionalHabilidadService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<ProfesionalHabilidad>update(@PathVariable Long id, @RequestBody ProfesionalHabilidad entity){
        try {
            return ResponseEntity.ok().body(profesionalHabilidadService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
