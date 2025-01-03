package com.example.teste.junior.http.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.teste.junior.entity.Usuario;
import com.example.teste.junior.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPorId(@PathVariable("id") Long id) {
        return usuarioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerUsuario(@PathVariable("id") Long id) {
        usuarioService.buscarPorId(id)
                .map(usuario -> {
                    usuarioService.removerPorId(usuario.getId());
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        usuarioService.buscarPorId(id)
                .map(usuarioBase -> {
                    modelMapper.map(usuario, usuarioBase);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));

    }
}
