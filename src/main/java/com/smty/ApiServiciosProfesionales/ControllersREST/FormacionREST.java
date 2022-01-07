package com.smty.ApiServiciosProfesionales.ControllersREST;
import com.smty.ApiServiciosProfesionales.Models.Formacion;
import com.smty.ApiServiciosProfesionales.Repositories.FormacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/formacion")
public class FormacionREST {
    @Autowired
    private FormacionRepository formacionRepository;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Formacion>> getAll(){
        List<Formacion>lista = formacionRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Formacion> finfById(@PathVariable("id")Long id){
        Optional<Formacion> optional =formacionRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Formacion> create (@RequestBody Formacion objeto) {
        Formacion newObjeto =  formacionRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Long id) {
        formacionRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<Formacion>update(@RequestBody Formacion objeto){
        Optional<Formacion> optional =formacionRepository.findById(objeto.getIdFormacion());
        if(optional.isPresent()) {
            Formacion update=optional.get();
           // update.setIdPais(objeto.getIdPais());
            update.setNombreInstitucion(objeto.getNombreInstitucion());
            update.setDescripcion(objeto.getDescripcion());
            formacionRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
