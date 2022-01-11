package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.Habilidad;
import com.smty.ApiServiciosProfesionales.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HabilidadService {
    @Autowired
    private HabilidadRepository habilidadRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Habilidad> findAll() throws Exception{
        try {
            return (List<Habilidad>)  habilidadRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar un habilidad mediante su ID.
    @Transactional
    public Habilidad findById(int id) throws Exception{
        try {
            Optional<Habilidad> entityOptional = habilidadRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Habilidad save(Habilidad entity) throws Exception{
        try {
            entity = habilidadRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Habilidad update(int id, Habilidad entity) throws Exception{
        try {
            Optional<Habilidad> entityOptional = habilidadRepository.findById(id);
            Habilidad habilidad = entityOptional.get();
            habilidad = habilidadRepository.save(habilidad);
            return  habilidad;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception{
        try {
            if(habilidadRepository.existsById(id)){
                habilidadRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

}
