package com.zup.pizzaria.controller;

import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation         .Valid;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<?> criarCliente(@Valid @RequestBody Cliente cliente, BindingResult bindingResult) {
        // Verificar se houve erro na validação
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        // Persistir o cliente no banco de dados
        Cliente clienteSalvo = clienteRepository.save(cliente);

        // Retornar a resposta com código HTTP 201 (Created)
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }
}
