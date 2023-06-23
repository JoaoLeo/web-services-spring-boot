package com.curso.services;

import com.curso.entities.Usuario;
import com.curso.repositories.UsuarioRepository;
import com.curso.services.exceptions.DatabaseException;
import com.curso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //transforma em service para poder injetar com auto wired
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario obj){
       return repository.save(obj);
    }

    public void delete(Long id){
        try {
            if(repository.existsById(id)) {
                repository.deleteById(id);
            }
            else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException err){
            throw new DatabaseException(err.getMessage());
        }

    }
    public Usuario update(Long id, Usuario obj){
        try {
            Usuario entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException err){
            throw new ResourceNotFoundException(err);
        }

    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());
    }

}