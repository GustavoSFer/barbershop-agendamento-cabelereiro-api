package com.fernandes.barbershop_agendamento_cabelereiro_api.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AssinaturaDTO(
    @NotBlank(message = "Deve ser informado a data de inicio!")
    LocalDate inicio,
    @NotBlank(message = "Deve ser informado a data fim!")
    LocalDate fim,
    @NotBlank(message = "Deve ser informado se a assinatura é pago por mês!")
    boolean pagoNoMes,
    @NotBlank(message = "Deve ser informado o id da pessoa!")
    Long pessoa,
    @NotBlank(message = "Deve ser informado o id do plano para essa assinatura!")
    Long plano
){}
