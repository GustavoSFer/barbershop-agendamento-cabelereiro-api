package com.fernandes.barbershop_agendamento_cabelereiro_api.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
}
