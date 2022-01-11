package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.Formacion;
import com.smty.ApiServiciosProfesionales.Repositories.FormacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class FormacionService {
    @Autowired
    private FormacionRepository formacionRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Formacion> findAll() throws Exception{
        try {
            return (List<Formacion>)  formacionRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar un formacion mediante su ID.
    @Transactional
    public Formacion findById(int id) throws Exception{
        try {
            Optional<Formacion> entityOptional = formacionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Formacion save(Formacion entity) throws Exception{
        try {
            entity = formacionRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Formacion update(int id, Formacion entity) throws Exception{
        try {
            Optional<Formacion> entityOptional = formacionRepository.findById(id);
            Formacion formacion = entityOptional.get();
            formacion = formacionRepository.save(formacion);
            return  formacion;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception{
        try {
            if(formacionRepository.existsById(id)){
                formacionRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
