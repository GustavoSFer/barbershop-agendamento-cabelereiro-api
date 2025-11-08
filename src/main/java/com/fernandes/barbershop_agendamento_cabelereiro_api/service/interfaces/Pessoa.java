package com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces;

import java.util.List;

public interface Pessoa {

    Pessoa create(Pessoa pessoa);
    List<Pessoa> pessoas();
    Pessoa findById(Long id);
    Pessoa update(Pessoa pessoa);
    void excluir(Long id);
}
