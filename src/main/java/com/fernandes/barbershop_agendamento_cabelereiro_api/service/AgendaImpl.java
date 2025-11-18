package com.fernandes.barbershop_agendamento_cabelereiro_api.service;

import com.fernandes.barbershop_agendamento_cabelereiro_api.dto.AgendamentoDTO;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.*;
import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.AgendaException.AgendaNotFoundException;
import com.fernandes.barbershop_agendamento_cabelereiro_api.repository.AgendaRepository;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.AgendaInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PessoaInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PlanoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaImpl implements AgendaInterface {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private PessoaInterface pessoaInterface;

    @Autowired
    private PlanoInterface planoInterface;

    @Override
    public Agenda create(AgendamentoDTO agendamentoDTO) {
        Pessoa pessoa = pessoaInterface.findById(agendamentoDTO.pessoaid());

        if (agendamentoDTO.dataAgendamento().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data do agendamento não pode ser menor que a data atual.");
        }

        List<Assinatura> assinaturas = pessoa.getAssinaturas();
        boolean possuiAssinatura = assinaturas.stream().anyMatch(ass ->
                !agendamentoDTO.dataAgendamento().toLocalDate().isBefore(ass.getInicio()) &&
                !agendamentoDTO.dataAgendamento().toLocalDate().isAfter(ass.getFim()));

        if (!possuiAssinatura) {
            throw new IllegalArgumentException("A pessoa não possui uma assinatura ativa");
        }

        Agenda agenda = Agenda.builder()
                .dataHora(agendamentoDTO.dataAgendamento())
                .pessoa(pessoa)
                .build();

        return agendaRepository.save(agenda);
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
