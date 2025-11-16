package com.fernandes.barbershop_agendamento_cabelereiro_api.service;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Agenda;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Corte;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Pessoa;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Plano;
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
    public Agenda create(Agenda agenda) {
        Pessoa pessoa = pessoaInterface.findById(agenda.getPessoa().getId());
        Corte corte = null;
        if (agenda.getCorte() != null && agenda.getCorte().getId() != null) {
            corte = corteInterface.findById(agenda.getCorte().getId());
        }

        Plano plano = null;
        if (agenda.getPlano() != null && agenda.getPlano().getId() != null) {
            plano = planoInterface.findById(agenda.getPlano().getId());
        }

        agenda.setPessoa(pessoa);
        agenda.setPlano(plano);
        agenda.setCorte(corte);
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

        agendaBanco.setCorte(agenda.getCorte());
        agendaBanco.setPago(agenda.isPago());
        agendaBanco.setPessoa(agenda.getPessoa());
        agendaBanco.setDataHora(agenda.getDataHora());
        agendaBanco.setPlano(agenda.getPlano());
        agendaBanco.setValor(agenda.getValor());

        return agendaRepository.save(agendaBanco);
    }

    @Override
    public void excluir(Long id) {
        Agenda agenda = findById(id);

        agendaRepository.delete(agenda);
    }
}
