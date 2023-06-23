package com.curso.services;

import com.curso.entities.Usuario;
import com.curso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }

    public Usuario insert(Usuario obj){
       return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}