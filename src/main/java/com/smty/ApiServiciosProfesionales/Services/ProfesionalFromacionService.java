package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.ProfesionalFormacion;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalFormacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalFromacionService {

    @Autowired
    private ProfesionalFormacionRepository profesionalFormacionRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<ProfesionalFormacion> findAll() throws Exception{
        try {
            return (List<ProfesionalFormacion>)  profesionalFormacionRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar un profesionalHabilidad mediante su ID.
    @Transactional
    public ProfesionalFormacion findById(Long id) throws Exception{
        try {
            Optional<ProfesionalFormacion> entityOptional = profesionalFormacionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public ProfesionalFormacion save(ProfesionalFormacion entity) throws Exception{
        try {
            entity = profesionalFormacionRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public ProfesionalFormacion update(Long id, ProfesionalFormacion entity) throws Exception{
        try {
            Optional<ProfesionalFormacion> entityOptional = profesionalFormacionRepository.findById(id);
            ProfesionalFormacion profesionalFormacion = entityOptional.get();
            profesionalFormacion = profesionalFormacionRepository.save(profesionalFormacion);
            return  profesionalFormacion;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception{
        try {
            if(profesionalFormacionRepository.existsById(id)){
                profesionalFormacionRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

}
