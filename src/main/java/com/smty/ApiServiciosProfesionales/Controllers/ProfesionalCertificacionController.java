package com.smty.ApiServiciosProfesionales.Controllers;
import com.smty.ApiServiciosProfesionales.Models.ProfesionalCertificacion;
import com.smty.ApiServiciosProfesionales.Services.ProfesionalCertificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/profesionalesCertificaciones")
public class ProfesionalCertificacionController {
    @Autowired
    private ProfesionalCertificacionService profesionalCertificacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ProfesionalCertificacion>> getAll() {
        try {
            return ResponseEntity.ok().body(profesionalCertificacionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ProfesionalCertificacion> finfById(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok().body(profesionalCertificacionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ProfesionalCertificacion> create (@RequestBody ProfesionalCertificacion entity) {
        try {
            return ResponseEntity.ok().body(profesionalCertificacionService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(profesionalCertificacionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<ProfesionalCertificacion>update(Long id, @RequestBody ProfesionalCertificacion entity){
        try {
            return ResponseEntity.ok().body(profesionalCertificacionService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



}
