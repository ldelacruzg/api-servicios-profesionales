package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.ProfesionalCertificacion;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalCertificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ProfesionalCertificacionService {

    @Autowired
    private ProfesionalCertificacionRepository profesionalCertificacionRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<ProfesionalCertificacion> findAll() throws Exception{
        try {
            return (List<ProfesionalCertificacion>)  profesionalCertificacionRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar un profesionalCertificacion mediante su ID.
    @Transactional
    public ProfesionalCertificacion findById(Long id) throws Exception{
        try {
            Optional<ProfesionalCertificacion> entityOptional = profesionalCertificacionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public ProfesionalCertificacion save(ProfesionalCertificacion entity) throws Exception{
        try {
            entity = profesionalCertificacionRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public ProfesionalCertificacion update(Long id, ProfesionalCertificacion entity) throws Exception{
        try {
            Optional<ProfesionalCertificacion> entityOptional = profesionalCertificacionRepository.findById(id);
            ProfesionalCertificacion profesionalCertificacion = entityOptional.get();
            profesionalCertificacion = profesionalCertificacionRepository.save(profesionalCertificacion);
            return  profesionalCertificacion;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception{
        try {
            if(profesionalCertificacionRepository.existsById(id)){
                profesionalCertificacionRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

}
