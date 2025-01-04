package com.example.teste.junior.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teste.junior.entity.Conta;
import com.example.teste.junior.entity.Transacao;
import com.example.teste.junior.repository.ContaRepository;
import com.example.teste.junior.repository.TransacaoRepository;

@Service
public class TransferenciaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> listarTransacoes() {
        return transacaoRepository.findAll();
    }

    @Transactional
    public Transacao realizarTransferencia(Long idContaOrigem, Long idContaDestino, Double valor) {
        // Verificar se as contas existem
        Conta contaOrigem = contaRepository.findById(idContaOrigem)
                .orElseThrow(() -> new RuntimeException("Conta de origem não encontrada (404)"));
        Conta contaDestino = contaRepository.findById(idContaDestino)
                .orElseThrow(() -> new RuntimeException("Conta de destino não encontrada (404)"));

        // Validar saldo da conta de origem
        contaOrigem.debitar(valor);

        // Creditar o valor na conta de destino
        contaDestino.creditar(valor);

        // Persistir a transferência
        Transacao transacao = new Transacao(contaOrigem, contaDestino, valor);
        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);
        return transacaoRepository.save(transacao);
    }

}
