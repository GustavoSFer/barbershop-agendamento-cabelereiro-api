package com.fernandes.barbershop_agendamento_cabelereiro_api.controller;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Agenda;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.AgendaInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.AgendaInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaInterface agendaService;

    @PostMapping
    public ResponseEntity<Agenda> create(@Valid @RequestBody Agenda agenda) {
        Agenda agendaCriada = agendaService.create(agenda);

        return ResponseEntity.created(URI.create("/agendas")).body(agendaCriada);
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> listarAgendas() {
        List<Agenda> agendas = agendaService.findAll();

        return ResponseEntity.ok().body(agendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> findById(@PathVariable Long id) {
        Agenda agenda = agendaService.findById(id);

        return ResponseEntity.ok().body(agenda);
    }

    @PutMapping
    public ResponseEntity<Agenda> updateAgenda(@Valid @RequestBody Agenda agenda) {
        Agenda agendaAtualizada = agendaService.update(agenda);

        return ResponseEntity.ok().body(agendaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Long id) {
        agendaService.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
