package com.fernandes.barbershop_agendamento_cabelereiro_api.service;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Plano;
import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.PlanoException.PlanoNotFoundException;
import com.fernandes.barbershop_agendamento_cabelereiro_api.repository.PlanoRepository;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PlanoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoImpl implements PlanoInterface {

    @Autowired
    private PlanoRepository planoRepository;

    @Override
    public Plano create(Plano plano) {
        return planoRepository.save(plano);
    }

    @Override
    public List<Plano> findAll() {
        return planoRepository.findAll();
    }

    @Override
    public Plano findById(Long id) {
        Optional<Plano> plano = planoRepository.findById(id);

        return plano.orElseThrow(() -> new PlanoNotFoundException("Plano não encontrado!"));
    }

    @Override
    public Plano update(Plano plano) {
        Plano planoBanco = findById(plano.getId());

        planoBanco.setNome(plano.getNome());
        planoBanco.setValor(plano.getValor());
        planoBanco.setAtivo(plano.getAtivo());

        return planoRepository.save(planoBanco);
    }

    @Override
    public void excluir(Long id) {
        Plano plano = findById(id);

        planoRepository.delete(plano);
    }
}
