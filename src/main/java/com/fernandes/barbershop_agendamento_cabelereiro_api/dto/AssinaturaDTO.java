package com.fernandes.barbershop_agendamento_cabelereiro_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AssinaturaDTO(
        @NotNull(message = "Deve ser informado a data de inicio!")
        LocalDate inicio,
        @NotNull(message = "Deve ser informado a data fim!")
        LocalDate fim,
        @NotNull(message = "Deve ser informado se a assinatura é pago por mês!")
        boolean pagoNoMes,
        @NotNull(message = "Deve ser informado o id da pessoa!")
        Long pessoa,
        @NotNull(message = "Deve ser informado o id do plano para essa assinatura!")
        Long plano
){}
