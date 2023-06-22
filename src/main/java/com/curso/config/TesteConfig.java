package com.curso.config;

import com.curso.entities.*;
import com.curso.entities.enums.PedidoStatus;
import com.curso.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    @Autowired //resolve a dependencia
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public void run(String... args) throws Exception { //Executa assim que a aplicação for iniciada
        Usuario u1 = new Usuario(null, "teste 1", "teste1@gmail.com", "9876543210", "123");
        Usuario u2 = new Usuario(null, "teste 2", "teste2@gmail.com", "9876543210", "123");
        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.ESPERANDO_PAGAMENTO, u2);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ESPERANDO_PAGAMENTO, u1);
        Categoria cat1 = new Categoria(null, "Teste Categoria1");
        Categoria cat2 = new Categoria(null, "Teste Categoria2");
        Categoria cat3 = new Categoria(null, "Teste Categoria3");
        Produto prod1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto prod2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto prod3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto prod4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto prod5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        ItemPedido oi1 = new ItemPedido(p1, prod1, 2, prod1.getPreco());
        ItemPedido oi2 = new ItemPedido(p1, prod3, 1, prod3.getPreco());
        ItemPedido oi3 = new ItemPedido(p2, prod3, 2, prod3.getPreco());
        ItemPedido oi4 = new ItemPedido(p3, prod5, 2, prod5.getPreco());
        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4,prod5));
        prod1.getCategorias().add(cat2);
        prod2.getCategorias().add(cat1);
        prod2.getCategorias().add(cat3);
        prod3.getCategorias().add(cat3);
        prod4.getCategorias().add(cat3);
        prod5.getCategorias().add(cat2);
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4,prod5));
        itemPedidoRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
    }
}
