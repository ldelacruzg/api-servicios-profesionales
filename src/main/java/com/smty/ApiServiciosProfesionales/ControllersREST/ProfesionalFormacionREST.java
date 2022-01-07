package com.smty.ApiServiciosProfesionales.ControllersREST;
import com.smty.ApiServiciosProfesionales.Models.ProfesionalFormacion;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalFormacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/formacion")
public class ProfesionalFormacionREST {
    @Autowired
    private ProfesionalFormacionRepository profesionalFormacionRepository;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ProfesionalFormacion>> getAll(){
        List<ProfesionalFormacion>lista = profesionalFormacionRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ProfesionalFormacion> finfById(@PathVariable("id")Long id){
        Optional<ProfesionalFormacion> optional =profesionalFormacionRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ProfesionalFormacion> create (@RequestBody ProfesionalFormacion objeto) {
        ProfesionalFormacion newObjeto =  profesionalFormacionRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Long id) {
        profesionalFormacionRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<ProfesionalFormacion>update(@RequestBody ProfesionalFormacion objeto){
        Optional<ProfesionalFormacion> optional =profesionalFormacionRepository.findById(objeto.getIdProfesionalForomacion());
        if(optional.isPresent()) {
            ProfesionalFormacion update=optional.get();
            update.setFormacion(objeto.getFormacion());
            update.setYear(objeto.getYear());
            profesionalFormacionRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
