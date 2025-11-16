package com.fernandes.barbershop_agendamento_cabelereiro_api.controller;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Assinatura;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.AgendaInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    @Autowired
    private AgendaInterface agendaService;

    @PostMapping
    public ResponseEntity<Assinatura> criarAssinatura(@Valid @RequestBody Assinatura assinatura) {


        return null;
    }

}
