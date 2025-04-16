package com.desafio.nubank.controller;

import com.desafio.nubank.dto.ClienteDTO;
import com.desafio.nubank.dto.ContatoDTO;
import com.desafio.nubank.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrarCliente(clienteDTO));
    }

    @PostMapping("/contato/{idCliente}")
    public ResponseEntity<ContatoDTO> cadastrarContato(@RequestBody ContatoDTO contatoDTO, @PathVariable Long idCliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrarContato(contatoDTO, idCliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes () {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarClientes());
    }

    @GetMapping("/contato/{id}")
    public ResponseEntity<List<ContatoDTO>> listarContatos(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarContatosByIdCliente(id).contatos());
    }
}
