package com.fernandes.barbershop_agendamento_cabelereiro_api.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AgendamentoDTO(
        @NotBlank(message = "O id da pessoa deve ser informado!")
        Long pessoaid,

        @NotBlank(message = "O id do corte, deve ser informado!")
        Long corteId,

        @NotBlank(message = "A data e o horario, deve ser informado!")
        LocalDateTime dataAgendamento
) {
}
