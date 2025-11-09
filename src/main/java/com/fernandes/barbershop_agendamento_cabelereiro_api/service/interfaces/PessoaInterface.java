package com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Pessoa;
import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.pessoaException.PessoaNotFoundException;

import java.util.List;

public interface PessoaInterface {

    Pessoa create(Pessoa pessoa);
    List<Pessoa> findAll();
    Pessoa findById(Long id);
    Pessoa update(Pessoa pessoa);
    void excluir(Long id);
}
