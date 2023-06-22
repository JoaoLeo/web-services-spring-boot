package com.curso.repositories;

import com.curso.entities.Pedido;
import com.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
