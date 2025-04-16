package com.desafio.nubank.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
