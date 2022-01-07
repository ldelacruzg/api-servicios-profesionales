package com.smty.ApiServiciosProfesionales.ControllersREST;
import com.smty.ApiServiciosProfesionales.Models.ProfesionalCertificacion;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalCertificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/profesionalCertificacipn")
public class ProfesionalCertificacionREST {
    @Autowired
    private ProfesionalCertificacionRepository profesionalCertificacionRepository;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<ProfesionalCertificacion>> getAll(){
        List<ProfesionalCertificacion> lista = profesionalCertificacionRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<ProfesionalCertificacion> finfById(@PathVariable("id")Long id){
        Optional<ProfesionalCertificacion> optional =profesionalCertificacionRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<ProfesionalCertificacion> create (@RequestBody ProfesionalCertificacion objeto) {
        ProfesionalCertificacion newObjeto =  profesionalCertificacionRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Long id) {
        profesionalCertificacionRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<ProfesionalCertificacion>update(@RequestBody ProfesionalCertificacion objeto){
        Optional<ProfesionalCertificacion> optional =profesionalCertificacionRepository.findById(objeto.getIdProfesionalCertificacion());
        if(optional.isPresent()) {
            ProfesionalCertificacion update=optional.get();
            update.setProfesional(objeto.getProfesional());
            update.setCertificacion(objeto.getCertificacion());
            update.setYear(objeto.getYear());
            profesionalCertificacionRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }



}
