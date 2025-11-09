package com.fernandes.barbershop_agendamento_cabelereiro_api.controller;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Pessoa;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PessoaInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaservice.findAll();

        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa pessoa = pessoaservice.findById(id);

        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping
    public ResponseEntity<Pessoa> updatePessoa(@Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaAtualizada = pessoaservice.update(pessoa);

        return ResponseEntity.ok().body(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        pessoaservice.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
