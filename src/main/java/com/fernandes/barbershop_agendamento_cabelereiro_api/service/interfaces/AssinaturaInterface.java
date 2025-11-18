package com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces;

import com.fernandes.barbershop_agendamento_cabelereiro_api.dto.AssinaturaDTO;
import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Assinatura;

public interface AssinaturaInterface {
    Assinatura criarAssinatura(AssinaturaDTO assinaturaDTO);
}
