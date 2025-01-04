package com.example.teste.junior.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.teste.junior.entity.Transacao;
import com.example.teste.junior.service.TransferenciaService;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<Transacao> realizarTransferencia(
            @RequestParam Long contaOrigemId,
            @RequestParam Long contaDestinoId,
            @RequestParam Double valor) {
        Transacao transacao = transferenciaService.realizarTransferencia(contaOrigemId, contaDestinoId, valor);
        return ResponseEntity.ok(transacao);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes() {
        return ResponseEntity.ok(transferenciaService.listarTransacoes());
    }
}

