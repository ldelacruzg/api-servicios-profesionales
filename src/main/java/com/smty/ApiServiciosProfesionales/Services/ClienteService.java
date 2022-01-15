package com.smty.ApiServiciosProfesionales.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smty.ApiServiciosProfesionales.Models.Cliente;
import com.smty.ApiServiciosProfesionales.Repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Cliente> findAll() throws Exception
    {
        try
        {
            return clienteRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un cliente mediante su ID.
    @Transactional
    public Cliente findById(Long id) throws Exception
    {
        try
        {
            Optional<Cliente> entityOptional = clienteRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Cliente save(Cliente entity) throws Exception
    {
        try
        {
            entity = clienteRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Cliente update(Long id, Cliente entity) throws Exception
    {
        try
        {
            Optional<Cliente> entityOptional = clienteRepository.findById(id);
            Cliente cliente = entityOptional.get();
            cliente = clienteRepository.save(entity);
            return  cliente;
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
            if(clienteRepository.existsById(id))
            {
            	clienteRepository.deleteById(id);
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
