package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.Certificacion;
import com.smty.ApiServiciosProfesionales.Repositories.CertificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CertificacionService {
    @Autowired
    private CertificacionRepository certificacionRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Certificacion> findAll() throws Exception{
        try {
            return certificacionRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un certificacion mediante su ID.
    @Transactional
    public Certificacion findById(int id) throws Exception{
        try {
            Optional<Certificacion> entityOptional = certificacionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Certificacion save(Certificacion entity) throws Exception{
        try {
            entity = certificacionRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Certificacion update(int id, Certificacion entity) throws Exception{
        try {
            Optional<Certificacion> entityOptional = certificacionRepository.findById(id);
            Certificacion certificacion = entityOptional.get();
            certificacion = certificacionRepository.save(entity);
            return  certificacion;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception{
        try {
            if(certificacionRepository.existsById(id)){
                certificacionRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
