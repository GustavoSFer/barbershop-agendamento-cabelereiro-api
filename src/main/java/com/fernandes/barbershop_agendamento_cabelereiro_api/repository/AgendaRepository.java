package com.fernandes.barbershop_agendamento_cabelereiro_api.repository;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
