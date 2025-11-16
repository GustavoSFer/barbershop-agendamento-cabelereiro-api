package com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces;

import com.fernandes.barbershop_agendamento_cabelereiro_api.dto.AgendamentoDTO;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Agenda;

import java.util.List;

public interface AgendaInterface {
    Agenda create(AgendamentoDTO agendamentoDTO);
    List<Agenda> findAll();
    Agenda findById(Long id);
    Agenda update(Agenda agenda);
    void excluir(Long id);
}
