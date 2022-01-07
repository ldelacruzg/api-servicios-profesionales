package com.smty.ApiServiciosProfesionales.ControllersREST;

import com.smty.ApiServiciosProfesionales.Models.Habilidad;
import com.smty.ApiServiciosProfesionales.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/habilidad")
public class HabilidadREST {
    @Autowired
    private HabilidadRepository habilidadRepository ;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Habilidad>> getAll(){
        List<Habilidad>lista = habilidadRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Habilidad> finfById(@PathVariable("id")Long id){
        Optional<Habilidad> optional =habilidadRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Habilidad> create (@RequestBody Habilidad objeto) {
        Habilidad newObjeto =  habilidadRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Long id) {
        habilidadRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<Habilidad>update(@RequestBody Habilidad objeto){
        Optional<Habilidad> optional =habilidadRepository.findById(objeto.getIdHabilidad());
        if(optional.isPresent()) {
            Habilidad update=optional.get();
            update.setNombre(objeto.getNombre());
            habilidadRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
