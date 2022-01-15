package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.PersonaIdioma;
import com.smty.ApiServiciosProfesionales.Repositories.PersonaIdiomaRepository;

@Service
public class PersonaIdiomaService {
	@Autowired
	private PersonaIdiomaRepository personaIdiomaService;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<PersonaIdioma> findAll() throws Exception
	{
		try
		{
			return (List<PersonaIdioma>) personaIdiomaService.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un plan mediante su ID.
	@Transactional
	public PersonaIdioma findById(Long id) throws Exception
	{
	    try
	    {
	        Optional<PersonaIdioma> entityOptional = personaIdiomaService.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public PersonaIdioma save(PersonaIdioma entity) throws Exception
	{
	    try
	    {
	        entity = personaIdiomaService.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public PersonaIdioma update(Long id, PersonaIdioma entity) throws Exception
    {
        try
        {
            Optional<PersonaIdioma> entityOptional = personaIdiomaService.findById(id);
            PersonaIdioma personaIdioma = entityOptional.get();
            personaIdioma = personaIdiomaService.save(personaIdioma);
            return  personaIdioma;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception
    {
        try
        {
            if(personaIdiomaService.existsById(id))
            {
            	personaIdiomaService.deleteById(id);
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
