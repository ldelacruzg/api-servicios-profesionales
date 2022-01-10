package com.smty.ApiServiciosProfesionales.Controllers;
import com.smty.ApiServiciosProfesionales.Controllers.Models.ProfesionalFormacion;
import com.smty.ApiServiciosProfesionales.Services.ProfesionalFromacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/ProfesionalesFormaciones")
public class ProfesionalFormacionController {
    @Autowired
    private ProfesionalFromacionService profesionalFromacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ProfesionalFormacion>> getAll() {
        try {
            return ResponseEntity.ok().body(profesionalFromacionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ProfesionalFormacion> finfById(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok().body(profesionalFromacionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ProfesionalFormacion> create (@RequestBody ProfesionalFormacion entity) {
        try {
            return ResponseEntity.ok().body(profesionalFromacionService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(profesionalFromacionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<ProfesionalFormacion>update(Long id, @RequestBody ProfesionalFormacion entity){
        try {
            return ResponseEntity.ok().body(profesionalFromacionService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
