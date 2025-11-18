package com.fernandes.barbershop_agendamento_cabelereiro_api.repository;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
}
