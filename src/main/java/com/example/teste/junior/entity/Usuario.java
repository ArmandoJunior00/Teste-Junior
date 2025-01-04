package com.example.teste.junior.entity;

import java.io.Serializable;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade")
    @Min(value = 18, message = "A idade deve ser maior ou igual a 18 anos.")
    private int idade;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "numeroConta")
    private String numeroConta;

    @PrePersist
    private void gerarNumeroConta() {
        if (this.numeroConta == null) {
            this.numeroConta = String.format("%08d", new Random().nextInt(1_0000_0000));
        }
    }

    @Column(name = "saldo")
    private double saldo;

}
