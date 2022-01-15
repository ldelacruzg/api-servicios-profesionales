package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.PreguntaServicio;
import com.smty.ApiServiciosProfesionales.Repositories.PreguntaServicioRepository;

@Service
public class PreguntaServicioService {
	@Autowired
	private PreguntaServicioRepository preguntaServicioRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<PreguntaServicio> findAll() throws Exception
	{
		try
		{
			return (List<PreguntaServicio>) preguntaServicioRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un plan mediante su ID.
	@Transactional
	public PreguntaServicio findById(int id) throws Exception
	{
	    try
	    {
	        Optional<PreguntaServicio> entityOptional = preguntaServicioRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public PreguntaServicio save(PreguntaServicio entity) throws Exception
	{
	    try
	    {
	        entity = preguntaServicioRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public PreguntaServicio update(int id, PreguntaServicio entity) throws Exception
    {
        try
        {
            Optional<PreguntaServicio> entityOptional = preguntaServicioRepository.findById(id);
            PreguntaServicio preguntaServicio = entityOptional.get();
            preguntaServicio = preguntaServicioRepository.save(preguntaServicio);
            return  preguntaServicio;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception
    {
        try
        {
            if(preguntaServicioRepository.existsById(id))
            {
            	preguntaServicioRepository.deleteById(id);
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