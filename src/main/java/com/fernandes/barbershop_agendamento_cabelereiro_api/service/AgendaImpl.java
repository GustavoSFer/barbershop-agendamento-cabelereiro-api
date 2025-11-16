package com.fernandes.barbershop_agendamento_cabelereiro_api.service;

import com.fernandes.barbershop_agendamento_cabelereiro_api.dto.AgendamentoDTO;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.*;
import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.AgendaException.AgendaNotFoundException;
import com.fernandes.barbershop_agendamento_cabelereiro_api.repository.AgendaRepository;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.AgendaInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.CorteInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PessoaInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PlanoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaImpl implements AgendaInterface {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private PessoaInterface pessoaInterface;

    @Autowired
    private CorteInterface corteInterface;

    @Autowired
    private PlanoInterface planoInterface;

    @Override
    public Agenda create(AgendamentoDTO agendamentoDTO) {
        Pessoa pessoa = pessoaInterface.findById(agendamentoDTO.pessoaid());
        Corte corte = corteInterface.findById(agendamentoDTO.corteId());

        return null;
    }

    @Override
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda findById(Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);

        return agenda.orElseThrow(() -> new AgendaNotFoundException("Agenda não encontrado!"));
    }

    @Override
    public Agenda update(Agenda agenda) {
        Agenda agendaBanco = findById(agenda.getId());

        agendaBanco.setCorte(agenda.getCorte());
        agendaBanco.setPessoa(agenda.getPessoa());
        agendaBanco.setDataHora(agenda.getDataHora());

        return agendaRepository.save(agendaBanco);
    }

    @Override
    public void excluir(Long id) {
        Agenda agenda = findById(id);

        agendaRepository.delete(agenda);
    }
}
