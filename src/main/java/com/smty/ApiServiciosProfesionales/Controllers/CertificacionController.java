package com.smty.ApiServiciosProfesionales.Controllers;

import com.smty.ApiServiciosProfesionales.Models.Certificacion;
import com.smty.ApiServiciosProfesionales.Services.CertificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/certificaciones")
public class CertificacionController {
    @Autowired
    private CertificacionService certificacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Certificacion>> getAll() {
        try {
            return ResponseEntity.ok().body(certificacionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Certificacion> finfById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().body(certificacionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Certificacion> create (@RequestBody Certificacion entity) {
        try {
            return ResponseEntity.ok().body(certificacionService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(certificacionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Certificacion>update(int id, @RequestBody Certificacion entity){
        try {
            return ResponseEntity.ok().body(certificacionService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
