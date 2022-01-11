package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.ProfesionalHabilidad;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalHabilidadService {
    @Autowired
    private ProfesionalHabilidadRepository profesionalHabilidadRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<ProfesionalHabilidad> findAll() throws Exception{
        try {
            return (List<ProfesionalHabilidad>)  profesionalHabilidadRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar un profesionalHabilidad mediante su ID.
    @Transactional
    public ProfesionalHabilidad findById(Long id) throws Exception{
        try {
            Optional<ProfesionalHabilidad> entityOptional = profesionalHabilidadRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public ProfesionalHabilidad save(ProfesionalHabilidad entity) throws Exception{
        try {
            entity = profesionalHabilidadRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public ProfesionalHabilidad update(Long id, ProfesionalHabilidad entity) throws Exception{
        try {
            Optional<ProfesionalHabilidad> entityOptional = profesionalHabilidadRepository.findById(id);
            ProfesionalHabilidad profesionalHabilidad = entityOptional.get();
            profesionalHabilidad = profesionalHabilidadRepository.save(profesionalHabilidad);
            return  profesionalHabilidad;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception{
        try {
            if(profesionalHabilidadRepository.existsById(id)){
                profesionalHabilidadRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

}
