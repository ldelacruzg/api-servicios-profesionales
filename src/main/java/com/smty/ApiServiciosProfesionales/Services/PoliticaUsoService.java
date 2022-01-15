package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.PoliticaUso;
import com.smty.ApiServiciosProfesionales.Repositories.PoliticaUsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PoliticaUsoService {
    @Autowired
    private PoliticaUsoRepository politicaUsoRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<PoliticaUso> findAll() throws Exception{
        try {
            return politicaUsoRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un politicaUso mediante su ID.
    @Transactional
    public PoliticaUso findById(int id) throws Exception{
        try {
            Optional<PoliticaUso> entityOptional = politicaUsoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public PoliticaUso save(PoliticaUso entity) throws Exception{
        try {
            entity = politicaUsoRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public PoliticaUso update(int id, PoliticaUso entity) throws Exception{
        try {
            Optional<PoliticaUso> entityOptional = politicaUsoRepository.findById(id);
            PoliticaUso politicaUso = entityOptional.get();
            politicaUso = politicaUsoRepository.save(entity);
            return  politicaUso;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception{
        try {
            if(politicaUsoRepository.existsById(id)){
                politicaUsoRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
