package com.curso.config;

import com.curso.entities.Pedido;
import com.curso.entities.Usuario;
import com.curso.repositories.PedidoRepository;
import com.curso.repositories.UsuarioRepository;
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

    @Override
    public void run(String... args) throws Exception { //Executa assim que a aplicação for iniciada
        Usuario u1 = new Usuario(null, "teste 1", "teste1@gmail.com", "9876543210", "123");
        Usuario u2 = new Usuario(null, "teste 2", "teste2@gmail.com", "9876543210", "123");
        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
