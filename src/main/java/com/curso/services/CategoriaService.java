package com.curso.services;

import com.curso.entities.Categoria;
import com.curso.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //transforma em service para poder injetar com auto wired
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> getAll() {
        return repository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.get();
    }
}