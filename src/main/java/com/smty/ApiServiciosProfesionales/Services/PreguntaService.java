package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.Pregunta;
import com.smty.ApiServiciosProfesionales.Repositories.PreguntaRepository;

@Service
public class PreguntaService {
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Pregunta> findAll() throws Exception
	{
		try
		{
			return (List<Pregunta>) preguntaRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar una pregunta mediante su ID.
	@Transactional
	public Pregunta findById(int id) throws Exception
	{
	    try
	    {
	        Optional<Pregunta> entityOptional = preguntaRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar
	@Transactional
	public Pregunta save(Pregunta entity) throws Exception
	{
	    try
	    {
	        entity = preguntaRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Pregunta update(int id, Pregunta entity) throws Exception
    {
        try
        {
            Optional<Pregunta> entityOptional = preguntaRepository.findById(id);
            Pregunta pregunta = entityOptional.get();
            pregunta = preguntaRepository.save(pregunta);
            return  pregunta;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID
    @Transactional
    public boolean delete(int id) throws Exception
    {
        try
        {
            if(preguntaRepository.existsById(id))
            {
            	preguntaRepository.deleteById(id);
                return  true;
            }
            else
            {
                throw  new Exception();
            }
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }
}
