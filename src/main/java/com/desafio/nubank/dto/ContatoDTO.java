package com.desafio.nubank.dto;

import lombok.Builder;

@Builder
public record ContatoDTO(
         String nome,
         String email,
         String telefone
) {
}
