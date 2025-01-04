package com.example.teste.junior.entity;

import jakarta.persistence.*;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroConta;

    @Column(nullable = false)
    private Double saldo;

    @Column(nullable = false)
    private String titular;

    public Conta() {
        // Construtor padrão
    }

    public Conta(String numeroConta, Double saldo, String titular) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.titular = titular;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Métodos utilitários
    public void debitar(Double valor) {
        if (valor > saldo) {
            throw new RuntimeException("Saldo insuficiente na conta de origem.");
        }
        this.saldo -= valor;
    }

    public void creditar(Double valor) {
        this.saldo += valor;
    }
}
