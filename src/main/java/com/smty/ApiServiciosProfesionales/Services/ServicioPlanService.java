package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.ServicioPlan;
import com.smty.ApiServiciosProfesionales.Repositories.ServicioPlanRepository;

@Service
public class ServicioPlanService {
	@Autowired
	private ServicioPlanRepository servicioPlanRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<ServicioPlan> findAll() throws Exception
	{
		try
		{
			return servicioPlanRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un ServicioPlan mediante su ID.
	@Transactional
	public ServicioPlan findById(Long id) throws Exception
	{
	    try
	    {
	        Optional<ServicioPlan> entityOptional = servicioPlanRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public ServicioPlan save(ServicioPlan entity) throws Exception
	{
	    try
	    {
	        entity = servicioPlanRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public ServicioPlan update(Long id, ServicioPlan entity) throws Exception
    {
        try
        {
            Optional<ServicioPlan> entityOptional = servicioPlanRepository.findById(id);
            ServicioPlan servicioPlan = entityOptional.get();
            servicioPlan = servicioPlanRepository.save(entity);
            return  servicioPlan;
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
            if(servicioPlanRepository.existsById(id))
            {
            	servicioPlanRepository.deleteById(id);
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
