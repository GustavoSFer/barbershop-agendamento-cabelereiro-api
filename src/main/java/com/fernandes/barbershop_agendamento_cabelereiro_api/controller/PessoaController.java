package com.fernandes.barbershop_agendamento_cabelereiro_api.controller;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Pessoa;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PessoaInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaInterface pessoaservice;

    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaCriada = pessoaservice.create(pessoa);

        return ResponseEntity.created(URI.create("/pessoas")).body(pessoaCriada);
    }
}
