package com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Corte;

import java.util.List;

public interface CorteInterface {
    Corte create(Corte corte);
    List<Corte> findAll();
    Corte findById(Long id);
    Corte update(Corte corte);
    void excluir(Long id);
}
