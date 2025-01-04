package com.example.teste.junior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste.junior.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}


