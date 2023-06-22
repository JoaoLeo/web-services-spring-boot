package com.curso.services;

import com.curso.entities.Pedido;
import com.curso.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //transforma em service para poder injetar com auto wired
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> getAll() {
        return repository.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.get();
    }
}