package com.fernandes.barbershop_agendamento_cabelereiro_api.service;

import com.fernandes.barbershop_agendamento_cabelereiro_api.dto.AssinaturaDTO;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Assinatura;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Pessoa;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Plano;
import com.fernandes.barbershop_agendamento_cabelereiro_api.repository.AssinaturaRepository;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.AssinaturaInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PessoaInterface;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PlanoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaImpl implements AssinaturaInterface {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @Autowired
    private PessoaInterface pessoaInterface;

    @Autowired
    private PlanoInterface planoInterface;

    @Override
    public Assinatura criarAssinatura(AssinaturaDTO assinaturaDTO) {
        Pessoa pessoa = pessoaInterface.findById(assinaturaDTO.pessoa());
        Plano plano = planoInterface.findById(assinaturaDTO.plano());

        Assinatura assinatura = Assinatura.builder()
                .inicio(assinaturaDTO.inicio())
                .fim(assinaturaDTO.fim())
                .pagoNoMes(assinaturaDTO.pagoNoMes())
                .pessoa(pessoa)
                .plano(plano)
                .build();

        return assinaturaRepository.save(assinatura);
    }
}
