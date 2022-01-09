package com.smty.ApiServiciosProfesionales.Controllers;
import com.smty.ApiServiciosProfesionales.Models.ProfesionalHabilidad;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ProfesionalHabilidad")
public class ProfesionalHabilidadController {
    @Autowired
    private ProfesionalHabilidadRepository profesionalHabilidadRepository;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ProfesionalHabilidad>> getAll(){
        List<ProfesionalHabilidad>lista = profesionalHabilidadRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ProfesionalHabilidad> finfById(@PathVariable("id")Long id){
        Optional<ProfesionalHabilidad> optional =profesionalHabilidadRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ProfesionalHabilidad> create (@RequestBody ProfesionalHabilidad objeto) {
        ProfesionalHabilidad newObjeto =  profesionalHabilidadRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Long id) {
        profesionalHabilidadRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<ProfesionalHabilidad>update(@RequestBody ProfesionalHabilidad objeto){
        Optional<ProfesionalHabilidad> optional =profesionalHabilidadRepository.findById(objeto.getIdProfesionalHabilidad());
        if(optional.isPresent()) {
            ProfesionalHabilidad update=optional.get();
            update.setHabilidad(objeto.getHabilidad());
            update.setNivel(objeto.getNivel());
            profesionalHabilidadRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
