package com.example.teste.junior.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste.junior.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}