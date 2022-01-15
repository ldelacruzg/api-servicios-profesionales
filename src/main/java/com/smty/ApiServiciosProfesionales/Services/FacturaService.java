package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.Factura;
import com.smty.ApiServiciosProfesionales.Repositories.FacturaRepository;

@Service
public class FacturaService {
	@Autowired
	private FacturaRepository facturaRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Factura> findAll() throws Exception
	{
		try
		{
			return (List<Factura>) facturaRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un plan mediante su ID.
	@Transactional
	public Factura findById(long id) throws Exception
	{
	    try
	    {
	        Optional<Factura> entityOptional = facturaRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public Factura save(Factura entity) throws Exception
	{
	    try
	    {
	        entity = facturaRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Factura update(long id, Factura entity) throws Exception
    {
        try
        {
            Optional<Factura> entityOptional = facturaRepository.findById(id);
            Factura factura = entityOptional.get();
            factura = facturaRepository.save(factura);
            return  factura;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(long id) throws Exception
    {
        try
        {
            if(facturaRepository.existsById(id))
            {
            	facturaRepository.deleteById(id);
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
