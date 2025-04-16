package com.desafio.nubank.dto;

import com.desafio.nubank.model.Contato;
import lombok.Builder;

import java.util.List;

@Builder
public record ClienteDTO(
         String nome,
         String email,
         int cpf,
         List<ContatoDTO> contatos
) {
}
