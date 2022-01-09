package com.smty.ApiServiciosProfesionales.Controllers;

import com.smty.ApiServiciosProfesionales.Models.Profesional;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/profesional")
public class ProfesionalController {
    @Autowired
    private ProfesionalRepository profesionalRepository;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Profesional>> getAll(){
        List<Profesional>lista = profesionalRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Profesional> finfById(@PathVariable("id")Long id){
        Optional<Profesional> optional =profesionalRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Profesional> create (@RequestBody Profesional objeto) {
        Profesional newObjeto =  profesionalRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Long id) {
        profesionalRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<Profesional>update(@RequestBody Profesional objeto){
        Optional<Profesional> optional =profesionalRepository.findById(objeto.getIdProfesional());
        if(optional.isPresent()) {
            Profesional update=optional.get();
            update.setUrlSitioWeb(objeto.getUrlSitioWeb());
            update.setUrlLinkedin(objeto.getUrlLinkedin());
            //update.setIdPersona(objeto.getIdPersona());
            profesionalRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
