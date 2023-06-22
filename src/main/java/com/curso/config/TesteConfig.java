package com.curso.config;

import com.curso.entities.Usuario;
import com.curso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    @Autowired //resolve a dependencia
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception { //Executa assim que a aplicação for iniciada
        Usuario u1= new Usuario(null, "teste 1", "teste1@gmail.com", "9876543210", "123");
        Usuario u2= new Usuario(null, "teste 2", "teste2@gmail.com", "9876543210", "123");
        usuarioRepository.saveAll(Arrays.asList(u1,u2));
    }
}
