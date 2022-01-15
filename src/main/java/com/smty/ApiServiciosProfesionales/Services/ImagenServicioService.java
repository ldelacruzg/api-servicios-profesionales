package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.ImagenServicio;
import com.smty.ApiServiciosProfesionales.Repositories.ImagenServicioRepository;

@Service
public class ImagenServicioService {
	@Autowired
	private ImagenServicioRepository imagenServicioRepository;
	
	//Este metodo permite listar todos los registros de la entidad.
    @Transactional
    public List<ImagenServicio> findAll() throws Exception
    {
        try
        {
            return imagenServicioRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una ImagenServicio mediante su ID.
    @Transactional
    public ImagenServicio findById(Long id) throws Exception
    {
        try
        {
            Optional<ImagenServicio> entityOptional = imagenServicioRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public ImagenServicio save(ImagenServicio entity) throws Exception
    {
        try
        {
            entity = imagenServicioRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public ImagenServicio update(Long id, ImagenServicio entity) throws Exception
    {
        try
        {
            Optional<ImagenServicio> entityOptional = imagenServicioRepository.findById(id);
            ImagenServicio imagenServicio = entityOptional.get();
            imagenServicio = imagenServicioRepository.save(entity);
            return  imagenServicio;
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
            if(imagenServicioRepository.existsById(id))
            {
            	imagenServicioRepository.deleteById(id);
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
