package com.desafio.nubank.converter;

import com.desafio.nubank.dto.ClienteDTO;
import com.desafio.nubank.dto.ContatoDTO;
import com.desafio.nubank.model.Cliente;
import com.desafio.nubank.model.Contato;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteConverter {

    public Cliente toClienteEntity(ClienteDTO clienteDTO) {
        return Cliente.builder()
                .nome(clienteDTO.nome())
                .email(clienteDTO.email())
                .cpf(clienteDTO.cpf())
                .contatos(toContatoEntityList(clienteDTO.contatos()))
                .build();
    }

    public ClienteDTO toClienteDto(Cliente cliente) {
        return ClienteDTO.builder()
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .cpf(cliente.getCpf())
                .contatos(toContatoDtoList(cliente.getContatos()))
                .build();
    }

    public Contato toContatoEntity(ContatoDTO contatoDTO) {
        return Contato.builder()
                .nome(contatoDTO.nome())
                .email(contatoDTO.email())
                .telefone(contatoDTO.telefone())
                .build();
    }

    public ContatoDTO toContatoDto(Contato contato) {
        return ContatoDTO.builder()
                .nome(contato.getNome())
                .email(contato.getEmail())
                .telefone(contato.getTelefone())
                .build();
    }

    public List<Contato> toContatoEntityList(List<ContatoDTO> dtoList) {
        return dtoList.stream()
                .map(this::toContatoEntity)
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> toContatoDtoList(List<Contato> entityList) {
        return entityList.stream()
                .map(this::toContatoDto)
                .collect(Collectors.toList());
    }
}
