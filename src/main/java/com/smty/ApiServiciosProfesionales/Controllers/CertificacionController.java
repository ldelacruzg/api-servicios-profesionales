package com.smty.ApiServiciosProfesionales.Controllers;

import com.smty.ApiServiciosProfesionales.Models.Certificacion;
import com.smty.ApiServiciosProfesionales.Repositories.CertificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/certificacion")
public class CertificacionController {
    @Autowired
    private CertificacionRepository certificacionRepository;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Certificacion>> getAll(){
        List<Certificacion>lista = certificacionRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Certificacion> finfById(@PathVariable("id")Integer id){
        Optional<Certificacion> optional =certificacionRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Certificacion> create (@RequestBody Certificacion objeto) {
        Certificacion newObjeto =  certificacionRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Integer id) {
        certificacionRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<Certificacion>update(@RequestBody Certificacion objeto){
        Optional<Certificacion> optional =certificacionRepository.findById(objeto.getIdCertificacion());
        if(optional.isPresent()) {
            Certificacion update=optional.get();
            update.setNombre(objeto.getNombre());
            certificacionRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
