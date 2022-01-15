package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.Imagen;
import com.smty.ApiServiciosProfesionales.Repositories.ImagenRepository;

@Service
public class ImagenService {
	@Autowired
	private ImagenRepository imagenRepository;
	
	//Este metodo permite listar todos los registros de la entidad.
    @Transactional
    public List<Imagen> findAll() throws Exception
    {
        try
        {
            return imagenRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una imagen mediante su ID.
    @Transactional
    public Imagen findById(Long id) throws Exception
    {
        try
        {
            Optional<Imagen> entityOptional = imagenRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Imagen save(Imagen entity) throws Exception
    {
        try
        {
            entity = imagenRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Imagen update(Long id, Imagen entity) throws Exception
    {
        try
        {
            Optional<Imagen> entityOptional = imagenRepository.findById(id);
            Imagen imagen = entityOptional.get();
            imagen = imagenRepository.save(entity);
            return  imagen;
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
            if(imagenRepository.existsById(id))
            {
            	imagenRepository.deleteById(id);
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
