package com.smty.ApiServiciosProfesionales.Controllers;

import com.smty.ApiServiciosProfesionales.Models.Plan;
import com.smty.ApiServiciosProfesionales.Repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/plan")
public class PlanController {
    @Autowired
    private PlanRepository planRepository;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Plan>> getAll(){
        List<Plan>lista = planRepository.findAll();
        return ResponseEntity.ok(lista);
    }


    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Plan> finfById(@PathVariable("id")int id){
        Optional<Plan> optional =planRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Plan> create (@RequestBody Plan objeto) {
        Plan newObjeto =  planRepository.save(objeto);
        return ResponseEntity.ok(newObjeto);
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Void> delete (@PathVariable("id")Integer id) {
        planRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //ACTUALIZAR
    @PutMapping
    private ResponseEntity<Plan>update(@RequestBody Plan objeto){
        Optional<Plan> optional =planRepository.findById(objeto.getIdPlan());
        if(optional.isPresent()) {
            Plan update=optional.get();
            update.setNombre(objeto.getNombre());
            planRepository.save(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
