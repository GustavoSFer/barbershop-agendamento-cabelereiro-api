package com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Plano;

import java.util.List;

public interface PlanoInterface {

    Plano create(Plano plano);
    List<Plano> findAll();
    Plano findById(Long id);
    Plano update(Plano plano);
    void excluir(Long id);
}
