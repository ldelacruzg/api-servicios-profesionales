package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.UsuarioIdioma;
import com.smty.ApiServiciosProfesionales.Repositories.UsuarioIdiomaRepository;

@Service
public class UsuarioIdiomaService {
	@Autowired
	private UsuarioIdiomaRepository usuarioIdiomaService;
	
	//Este metodo permite listar todos los registro de la entidad
	@Transactional
	public List<UsuarioIdioma> findAll() throws Exception
	{
		try
		{
			return (List<UsuarioIdioma>) usuarioIdiomaService.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar una PersonaIdioma mediante su ID.
	@Transactional
	public UsuarioIdioma findById(Long id) throws Exception
	{
	    try
	    {
	        Optional<UsuarioIdioma> entityOptional = usuarioIdiomaService.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public UsuarioIdioma save(UsuarioIdioma entity) throws Exception
	{
	    try
	    {
	        entity = usuarioIdiomaService.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public UsuarioIdioma update(Long id, UsuarioIdioma entity) throws Exception
    {
        try
        {
            Optional<UsuarioIdioma> entityOptional = usuarioIdiomaService.findById(id);
            UsuarioIdioma usuarioIdioma = entityOptional.get();
            usuarioIdioma = usuarioIdiomaService.save(entity);
            return  usuarioIdioma;
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
            if(usuarioIdiomaService.existsById(id))
            {
            	usuarioIdiomaService.deleteById(id);
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
