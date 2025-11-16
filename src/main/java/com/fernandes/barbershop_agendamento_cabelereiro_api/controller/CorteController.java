package com.fernandes.barbershop_agendamento_cabelereiro_api.controller;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Corte;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.CorteInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cortes")
public class CorteController {

    @Autowired
    private CorteInterface CorteService;

    @PostMapping
    public ResponseEntity<Corte> create(@Valid @RequestBody Corte corte) {
        Corte corteCriada = CorteService.create(corte);

        return ResponseEntity.created(URI.create("/Cortes")).body(corteCriada);
    }

    @GetMapping
    public ResponseEntity<List<Corte>> listarCortes() {
        List<Corte> cortes = CorteService.findAll();

        return ResponseEntity.ok().body(cortes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Corte> findById(@PathVariable Long id) {
        Corte corte = CorteService.findById(id);

        return ResponseEntity.ok().body(corte);
    }

    @PutMapping
    public ResponseEntity<Corte> updateCorte(@Valid @RequestBody Corte corte) {
        Corte corteAtualizada = CorteService.update(corte);

        return ResponseEntity.ok().body(corteAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorte(@PathVariable Long id) {
        CorteService.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
