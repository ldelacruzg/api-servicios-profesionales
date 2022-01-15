package com.smty.ApiServiciosProfesionales.Controllers;

import com.smty.ApiServiciosProfesionales.Models.PoliticaUso;
import com.smty.ApiServiciosProfesionales.Services.PoliticaUsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/politicasdeuso")
public class PoliticaUsoController {
    @Autowired
    private PoliticaUsoService politicaUsoService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<PoliticaUso>> getAll() {
        try {
            return ResponseEntity.ok().body(politicaUsoService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<PoliticaUso> finfById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().body(politicaUsoService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<PoliticaUso> create (@RequestBody PoliticaUso entity) {
        try {
            return ResponseEntity.ok().body(politicaUsoService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(politicaUsoService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<PoliticaUso>update(@PathVariable int id, @RequestBody PoliticaUso entity){
        try {
            return ResponseEntity.ok().body(politicaUsoService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
