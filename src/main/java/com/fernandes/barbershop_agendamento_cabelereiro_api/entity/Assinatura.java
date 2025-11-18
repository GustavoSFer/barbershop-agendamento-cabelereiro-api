package com.fernandes.barbershop_agendamento_cabelereiro_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate inicio;
    private LocalDate fim;
    private boolean pagoNoMes;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

}
