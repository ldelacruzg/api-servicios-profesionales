package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.DocumentoServicio;
import com.smty.ApiServiciosProfesionales.Repositories.DocumentoServicioRepository;

@Service
public class DocumentoServicioService {
	@Autowired
	private DocumentoServicioRepository documentoServicioRepository;
	
	//Este metodo permite listar todos los registros de la entidad.
    @Transactional
    public List<DocumentoServicio> findAll() throws Exception
    {
        try
        {
            return documentoServicioRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un DocumentoServicio mediante su ID.
    @Transactional
    public DocumentoServicio findById(Long id) throws Exception
    {
        try
        {
            Optional<DocumentoServicio> entityOptional = documentoServicioRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public DocumentoServicio save(DocumentoServicio entity) throws Exception
    {
        try
        {
            entity = documentoServicioRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public DocumentoServicio update(Long id, DocumentoServicio entity) throws Exception
    {
        try
        {
            Optional<DocumentoServicio> entityOptional = documentoServicioRepository.findById(id);
            DocumentoServicio documentoServicio = entityOptional.get();
            documentoServicio = documentoServicioRepository.save(entity);
            return  documentoServicio;
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
            if(documentoServicioRepository.existsById(id))
            {
            	documentoServicioRepository.deleteById(id);
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
