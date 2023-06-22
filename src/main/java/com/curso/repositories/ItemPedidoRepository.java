package com.curso.repositories;

import com.curso.entities.ItemPedido;
import com.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
