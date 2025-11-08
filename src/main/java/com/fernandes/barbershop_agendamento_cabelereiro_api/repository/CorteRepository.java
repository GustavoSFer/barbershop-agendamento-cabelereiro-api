package com.fernandes.barbershop_agendamento_cabelereiro_api.repository;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Corte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorteRepository extends JpaRepository<Corte, Long> {
}
