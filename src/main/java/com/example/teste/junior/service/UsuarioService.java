package com.example.teste.junior.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.junior.entity.Usuario;
import com.example.teste.junior.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public void removerPorId(Long id){
        usuarioRepository.deleteById(id);
    }
}
