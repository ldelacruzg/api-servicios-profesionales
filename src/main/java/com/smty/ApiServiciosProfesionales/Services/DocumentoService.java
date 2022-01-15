package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.Documento;
import com.smty.ApiServiciosProfesionales.Repositories.DocumentoRepository;

@Service
public class DocumentoService {
	@Autowired
	private DocumentoRepository documentoRepository;
	
	//Este metodo permite listar todos los registros de la entidad.
    @Transactional
    public List<Documento> findAll() throws Exception
    {
        try
        {
            return documentoRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un documento mediante su ID.
    @Transactional
    public Documento findById(Long id) throws Exception
    {
        try
        {
            Optional<Documento> entityOptional = documentoRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Documento save(Documento entity) throws Exception
    {
        try
        {
            entity = documentoRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Documento update(Long id, Documento entity) throws Exception
    {
        try
        {
            Optional<Documento> entityOptional = documentoRepository.findById(id);
            Documento documento = entityOptional.get();
            documento = documentoRepository.save(entity);
            return  documento;
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
            if(documentoRepository.existsById(id))
            {
            	documentoRepository.deleteById(id);
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
