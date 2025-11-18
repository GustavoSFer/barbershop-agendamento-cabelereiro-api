package com.fernandes.barbershop_agendamento_cabelereiro_api.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoDTO(
        @NotNull(message = "O id da pessoa deve ser informado!")
        Long pessoaid,

        @NotNull(message = "A data e o horario, deve ser informado!")
        LocalDateTime dataAgendamento
) {
}
