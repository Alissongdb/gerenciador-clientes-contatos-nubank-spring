package com.desafio.nubank.service;

import com.desafio.nubank.converter.ClienteConverter;
import com.desafio.nubank.dto.ClienteDTO;
import com.desafio.nubank.dto.ContatoDTO;
import com.desafio.nubank.model.Cliente;
import com.desafio.nubank.model.Contato;
import com.desafio.nubank.repository.ClienteRepository;
import com.desafio.nubank.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;
    private final ClienteConverter clienteConverter;

    //POST /clientes - Cadastro de cliente
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteConverter.toClienteEntity(clienteDTO);
        return clienteConverter.toClienteDto(clienteRepository.save(cliente));
    }

    //POST /contatos - Cadastro de contato, associado a um cliente existente
    public ContatoDTO cadastrarContato(ContatoDTO contatoDTO, Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Contato contato = clienteConverter.toContatoEntity(contatoDTO);
        contato.setCliente(cliente);

        return clienteConverter.toContatoDto(contatoRepository.save(contato));
    }

    //GET /clientes - Listagem de todos os clientes com seus contatos
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteConverter::toClienteDto)
                .toList();
    }

    //GET /clientes/{id}/contatos - Listagem de contatos de um cliente específico
    public ClienteDTO listarClientesById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return clienteConverter.toClienteDto(cliente);
    }



}
