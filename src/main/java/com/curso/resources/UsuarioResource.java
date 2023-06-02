package com.curso.resources;

import com.curso.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> getAll(){
        Usuario usuario = new Usuario(1L,"joao", "joao@gmail.com","61998819178", "123");
        return ResponseEntity.ok().body(usuario);
    }
}
