package com.fernandes.barbershop_agendamento_cabelereiro_api.service;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Corte;
import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.corteException.CorteNotFoundException;
import com.fernandes.barbershop_agendamento_cabelereiro_api.repository.CorteRepository;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.CorteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorteImpl implements CorteInterface {

    @Autowired
    private CorteRepository corteRepository;

    @Override
    public Corte create(Corte corte) {
        return corteRepository.save(corte);
    }

    @Override
    public List<Corte> findAll() {
        return corteRepository.findAll();
    }

    @Override
    public Corte findById(Long id) {
        Optional<Corte> corte = corteRepository.findById(id);

        return corte.orElseThrow(() -> new CorteNotFoundException("Corte não encontrado!"));
    }

    @Override
    public Corte update(Corte corte) {
        Corte corteBanco = findById(corte.getId());

        corteBanco.setNome(corte.getNome());
        corteBanco.setValor(corte.getValor());

        return corteRepository.save(corteBanco);
    }

    @Override
    public void excluir(Long id) {
        Corte corte = findById(id);

        corteRepository.delete(corte);
    }
}
