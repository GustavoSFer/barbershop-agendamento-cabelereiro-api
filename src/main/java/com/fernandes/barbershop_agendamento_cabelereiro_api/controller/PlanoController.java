package com.fernandes.barbershop_agendamento_cabelereiro_api.controller;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Plano;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PlanoInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PlanoInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoInterface planoService;

    @PostMapping
    public ResponseEntity<Plano> create(@Valid @RequestBody Plano Plano) {
        Plano PlanoCriada = planoService.create(Plano);

        return ResponseEntity.created(URI.create("/Planos")).body(PlanoCriada);
    }

    @GetMapping
    public ResponseEntity<List<Plano>> listarPlanos() {
        List<Plano> Planos = planoService.findAll();

        return ResponseEntity.ok().body(Planos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> findById(@PathVariable Long id) {
        Plano Plano = planoService.findById(id);

        return ResponseEntity.ok().body(Plano);
    }

    @PutMapping
    public ResponseEntity<Plano> updatePlano(@Valid @RequestBody Plano Plano) {
        Plano PlanoAtualizada = planoService.update(Plano);

        return ResponseEntity.ok().body(PlanoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable Long id) {
        planoService.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
