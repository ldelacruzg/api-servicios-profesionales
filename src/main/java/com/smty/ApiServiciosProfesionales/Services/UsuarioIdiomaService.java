package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.UsuarioIdioma;
import com.smty.ApiServiciosProfesionales.Repositories.UsuarioIdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioIdiomaService {

    @Autowired
    private UsuarioIdiomaRepository usuarioIdiomaRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<UsuarioIdioma> findAll() throws Exception{
        try {
            return usuarioIdiomaRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un usuarioIdioma mediante su ID.
    @Transactional
    public UsuarioIdioma findById(Long id) throws Exception{
        try {
            Optional<UsuarioIdioma> entityOptional = usuarioIdiomaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public UsuarioIdioma save(UsuarioIdioma entity) throws Exception{
        try {
            entity = usuarioIdiomaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public UsuarioIdioma update(Long id, UsuarioIdioma entity) throws Exception{
        try {
            Optional<UsuarioIdioma> entityOptional = usuarioIdiomaRepository.findById(id);
            UsuarioIdioma usuarioIdioma = entityOptional.get();
            usuarioIdioma = usuarioIdiomaRepository.save(entity);
            return  usuarioIdioma;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception{
        try {
            if(usuarioIdiomaRepository.existsById(id)){
                usuarioIdiomaRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
